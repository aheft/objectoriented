#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "array.h"

struct Performance *newPerformance(){
    struct Performance *newPerformance = calloc(1, sizeof(struct Performance));
    newPerformance->reads=0;
    newPerformance->writes=0;
    newPerformance->mallocs=0;
    newPerformance->frees=0;
    return (newPerformance);
}

struct Array *newArray(struct Performance *performance, unsigned int width, unsigned int capacity){
    struct Array *newArray=calloc(1, sizeof(struct Array));
    newArray->width=width;
    newArray->capacity=capacity;
    newArray->nel=0;
    newArray->data=calloc(width*capacity, 1);
    performance->mallocs+=1;
    return (newArray);
}

void readItem (struct Performance *performance, struct Array *array, unsigned int index, void *dest){
    if(index>=array->nel){
        fprintf(stderr, "Index out of bounds");
        exit (0);
    }
    //copy certain number of bytes (array width) from array data offset by index to destination.
    int offset = index*array->width;
    memcpy(dest, array->data+offset, array->width);
    performance->reads+=1;
}

void writeItem(struct Performance *performance, struct Array *array, unsigned int index, void *src){
    if(index>array->nel || index>=array->capacity){
        fprintf(stderr, "Index out of bounds");
        exit (0);
    }
    memcpy(array->data, src+(index*array->width), array->width);
    if (index==array->nel){
        array->nel+=1;
    }
    performance->writes+=1;
}


int main(){
    struct Performance *perf=newPerformance();
    struct Array *arr=newArray(perf, sizeof(int), 10);
    int *a=calloc(5, sizeof(int));
    for (i=0; i<5; i++){
        a[i]=i+1;
    }
    writeItem(perf, arr, 0, a);
    int *temp=arr->data;
    printf("%d\n", temp[0]);
    return 0;
}