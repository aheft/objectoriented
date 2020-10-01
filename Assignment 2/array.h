#ifndef ARRAY
#define ARRAY

struct Array{
    unsigned int width;
    unsigned int nel;
    unsigned int capacity;
    void *data;
};

struct Performance{
    unsigned int reads;
    unsigned int writes;
    unsigned int mallocs;
    unsigned int frees;
};

struct Performance *newPerformance();

struct Array *newArray(struct Performance *performance, unsigned int width, unsigned int capacity);

void readItem (struct Performance *performance, struct Array *array, unsigned int index, void *dest);

void writeItem(struct Performance *performance, struct Array *array, unsigned int index, void *src);

#endif