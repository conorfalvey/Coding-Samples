/* File:     dijkstra.c
 * Purpose:  Implement Dijkstra's algorithm for solving the single-source 
 *           shortest path problem:  find the length of the shortest path 
 *           between a specified vertex and all other vertices in a 
 *           directed graph.
 *
 * Input:    n, the number of vertices in the digraph
 *           mat, the adjacency matrix of the digraph
 * Output:   A list showing the cost of the shortest path
 *           from vertex 0 to every other vertex in the graph.
 *           and the vertices on the shortest path from 0 to
 *           every other vertex.
 *
 * Compile:  gcc -g -Wall -o dijkstra dijkstra.c
 * Run:      ./dijkstra
 *           For large matrices, put the matrix into a file with n as
 *           the first line and run with ./dijkstra < large_matrix
 *
 * Notes:
 * 1.  Edge lengths should be nonnegative.
 * 2.  The distance from v to w may not be the same as the distance from
 *     w to v.
 * 3.  If there is no edge between two vertices, the length is the constant
 *     INFINITY.  So input edge length should be substantially less than
 *     this constant.
 * 4.  The cost of travelling from a vertex to itself is 0.  So the adjacency
 *     matrix has zeroes on the main diagonal.
 * 5.  Edges joining different vertices have positive weights.
 * 6.  No error checking is done on the input.
 * 7.  The adjacency matrix is stored as a 1-dimensional array and subscripts
 *     are computed using the formula:  the entry in the ith row and jth
 *     column is mat[i*n + j]
 */
#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

const int INFINITY = 1000000;

void Read_matrix(int mat[], int n);
void Print_matrix(int mat[], int n);
void Print_dists(int dist[], int n);
void Print_paths(int pred[], int n);
int  Find_min_dist(int dist[], int known[], int n);
void Dijkstra(int mat[], int dist[], int pred[], int n);

int main(int argc, char *argv[]) {
   int  n;
   int *mat, *dist, *pred;
   int p, my_rank;
   MPI_Comm comm;

   int *local_mat, *local_dist, *local_pred;

   MPI_Init(&argc, &argv);
   comm = MPI_COMM_WORLD;
   MPI_Comm_size(comm, &p);
   MPI_Comm_rank(comm, &my_rank);

   if (my_rank == 0) {
      printf("How many vertices?\n");
      scanf("%d", &n);
      mat = malloc(n*n*sizeof(int));
      dist = malloc(n*sizeof(int));
      pred = malloc(n*sizeof(int));

      printf("Enter the matrix\n");
      Read_matrix(mat, n);
   }

   local_mat = malloc((n*n)/p*sizeof(int));
   local_dist = malloc(n*sizeof(int));
   local_pred = malloc(n*sizeof(int));

   if (my_rank == 0) {
      MPI_Scatter(mat, (n*n)/p, MPI_INT, local_mat, (n*n)/p, MPI_INT, 0, comm);
   }

   Dijkstra(local_mat, local_dist, local_pred, n);

   if (my_rank == 0) {
      MPI_Gather(local_dist, n/p, MPI_INT, dist, n/p, MPI_INT, 0, comm);

      printf("The distance from 0 to each vertex is:\n");
      Print_dists(dist, n);
      printf("The shortest path from 0 to each vertex is:\n");
      Print_paths(pred, n);

      free(mat);
      free(dist);
      free(pred);
   }

   free(local_mat);

   return 0;
}  /* main */

/*-------------------------------------------------------------------
 * Function:  Read_matrix
 * Purpose:   Read in the adjacency matrix
 * In arg:    n
 * Out arg:   mat
 */
void Read_matrix(int mat[], int n) {
   int i, j;

   for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
         scanf("%d", &mat[i*n+j]);
}  /* Read_matrix */

/*-------------------------------------------------------------------
 * Function:  Print_matrix
 * Purpose:   Print the contents of the matrix
 * In args:   mat, n
 */
void Print_matrix(int mat[], int n) {
   int i, j;

   for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++)
         if (mat[i*n+j] == INFINITY)
            printf("i ");
         else
            printf("%d ", mat[i*n+j]);
      printf("\n");
   }
}  /* Print_matrix */

/*-------------------------------------------------------------------
 * Function:    Dijkstra
 * Purpose:     Apply Dijkstra's algorithm to the matrix mat
 * In args:     n:  the number of vertices
 *              mat:  adjacency matrix for the graph
 * Out args:    dist:  dist[v] = distance 0 to v.
 *              pred:  pred[v] = predecessor of v on a 
 *                  shortest path 0->v.
 */
void Dijkstra(int mat[], int dist[], int pred[], int n) {
   int i, u, v, *known, new_dist;

   /* known[v] = true, if the shortest path 0->v is known */
   /* known[v] = false, otherwise                         */
   known = malloc(n*sizeof(int));

   /* Initialize d, p, and known */
   dist[0] = 0; pred[0] = 0; known[0] = 1; 
   for (v = 1; v < n; v++) {
      dist[v] = mat[0*n + v];
      pred[v] = 0;
      known[v] = 0;
   }

#  ifdef DEBUG
   printf("i = 0\n");
   Print_dists(dist, n);
#  endif

   /* On each pass find an additional vertex */
   /* whose distance to 0 is known           */
   for (i = 1; i < n; i++) {
      u = Find_min_dist(dist, known, n);

      known[u] = 1;

      for (v = 1; v < n; v++) 
         if (!known[v]) {
            new_dist = dist[u] + mat[u*n + v];
            if (new_dist < dist[v]) {
               dist[v] = new_dist;
               pred[v] = u;
            }
         }

#     ifdef DEBUG
      printf("i = %d\n", i);
      Print_dists(dist, n);
#     endif
   } /* for i */

   free(known);
}  /* Dijkstra */

/*-------------------------------------------------------------------
 * Function:    Find_min_dist
 * Purpose:     Find the vertex u with minimum distance to 0
 *              (dist[u]) among the vertices whose distance 
 *              to 0 is not known.
 * In args:     dist:  dist[v] = current estimate of distance
 *                 0->v
 *              known:  whether the minimum distance 0->v is
 *                 known
 *              n:  the total number of vertices
 * Ret val:     The vertex u whose distance to 0, dist[u]
 *              is a minimum among vertices whose distance
 *              to 0 is not known.
 */
int Find_min_dist(int dist[], int known[], int n) {
   // best_so_far should be INFINITY+1:  so loc_u=-1 isn't
   // chosen, when no remaining vertices can be reached
   int v, u, best_so_far = INFINITY + 1;

   for (v = 1; v < n; v++)
      if (!known[v])
         if (dist[v] < best_so_far) {
            u = v;
            best_so_far = dist[v];
         }

   return u;
}  /* Find_min_dist */


/*-------------------------------------------------------------------
 * Function:    Print_dists
 * Purpose:     Print the length of the shortest path from 0 to each
 *              vertex
 * In args:     n:  the number of vertices
 *              dist:  distances from 0 to each vertex v:  dist[v]
 *                 is the length of the shortest path 0->v
 */
void Print_dists(int dist[], int n) {
   int v;

   printf("  v    dist 0->v\n");
   printf("----   ---------\n");
                  
   for (v = 1; v < n; v++)
      printf("%3d       %4d\n", v, dist[v]);
   printf("\n");
} /* Print_dists */  


/*-------------------------------------------------------------------
 * Function:    Print_paths
 * Purpose:     Print the shortest path from 0 to each vertex
 * In args:     n:  the number of vertices
 *              pred:  list of predecessors:  pred[v] = u if
 *                 u precedes v on the shortest path 0->v
 */
void Print_paths(int pred[], int n) {
   int v, w, *path, count, i;

   path =  malloc(n*sizeof(int));

   printf("  v     Path 0->v\n");
   printf("----    ---------\n");
   for (v = 1; v < n; v++) {
      printf("%3d:    ", v);
      count = 0;
      w = v;
      while (w != 0) {
         path[count] = w;
         count++;
         w = pred[w];
      }
      printf("0 ");
      for (i = count-1; i >= 0; i--)
         printf("%d ", path[i]);
      printf("\n");
   }

   free(path);
}  /* Print_paths */