#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#include <time.h>
#include <string>
#include <iostream>
#include <fstream>

#define SIZE 100000000

using namespace std;

int main(int argc, char** argv)
{
	int n = SIZE;
	int* data = NULL;
	int chunk_size;
	int* chunk;
	int size, rank;
	MPI_Status status;
	double elapsed_time;
	int partial_sum = 0;
	int sum = 0;

	MPI_Init(NULL, NULL);
	MPI_Comm_size(MPI_COMM_WORLD, &size);
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);

	chunk_size = SIZE / size;

	if (rank == 0) {
		data = (int*)malloc(n * sizeof(int));
		FILE* input = fopen("E8N-7Digits.txt", "r");
		printf("E8N-9Digits.txt");
		char* temp = new char[10];
		for (int i = 0; i < SIZE ; i++) {
			fscanf(input,"%s\n",temp);
			data[i] = atoi(temp);

		}fclose(input);
		elapsed_time = -MPI_Wtime();
	}

	MPI_Barrier(MPI_COMM_WORLD);

	MPI_Bcast(&n, 1, MPI_INT, 0, MPI_COMM_WORLD);

	chunk = (int*)malloc(chunk_size * sizeof(int));
	MPI_Scatter(data, chunk_size, MPI_INT, chunk, chunk_size, MPI_INT, 0, MPI_COMM_WORLD);
	for (int i = 0; i < chunk_size; i++) {
		partial_sum += chunk[i];
	}
	free(data);
	data = NULL;

	MPI_Reduce(&partial_sum, &sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

	if (rank == 0) {
		elapsed_time += MPI_Wtime();
		printf("\n%d ", sum);
		printf("Sum %d ints on %d procs: %f miliseconds\n", SIZE, size, elapsed_time * 1000);
	}
	MPI_Finalize();
	return 0;
}

