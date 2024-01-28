#include <cstdlib>
#include <string>
#include <fstream>
#include <iostream>

typedef struct sf_block sf_block;

struct sf_block {
    size_t addr;
    char pred;
    int LRU;
    bool dirty;
};
    char junk, c;
    size_t addr;

using namespace std;

int main(int argc,char * argv[]) {
    if (argc != 2) {
        cout << "Wrong number of arguments.";
    }
    int hit_count, total_count;
    ifstream traceFile;
    traceFile.open(argv[1]);

    char simple[512];

    while(traceFile.is_open()) {
        for(int i = 0; i < traceFile.tellg(); i++) {
            traceFile >> simple[i];
        }

    }
    traceFile.close();

    for (int i = 0; i < sizeof(simple); i++){
        if(simple[i] == '@'){
            hit_count ++;
        }
        total_count ++;
    }


return 0;
}
