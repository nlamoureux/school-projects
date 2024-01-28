#include <cstdlib>
#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>
#include <vector>

using namespace std;

//Creating block and set struct
struct block {
    size_t * tag;
    bool dirty;
    uint64_t LRU;
};

struct set {
    block * block;
};

int runCache(int BPS, vector<int> cacheSim);
int totalCache (int BPS, vector<int> cacheSim);

int main (int argc, char*argv[]) {
    int hit_count;
    if(argc != 5){
        cout << "Incorrect number of arguments.";
    }
    //Getting command line argument values
    int direct_map_set = atoi(argv[1]);
    int blocks_per_set = atoi(argv[2]);
    int words_per_block = atoi(argv[3]);

    ifstream traceFile;
    traceFile.open(argv[0]);
    traceFile.peek();

    vector<int> cacheSim;

    //Read file into vector
    for(int i = 0; i < traceFile.tellg(); i++) {
        cacheSim.push_back(i);
        cout << cacheSim.at(i);
        i++;
    }

        traceFile.close();

    int total_count = runCache(blocks_per_set, cacheSim);
    hit_count = runCache(blocks_per_set, cacheSim);

    cout << "hits: " <<  hit_count << "/" << total_count;

}
//Function to get cache hits
int runCache(int BPS, vector<int> cacheSim){
    int set_cnt = 1 << strtol(BPS, NULL, 10);
    int block_cnt = atoi(BPS)^2;
    set * cache = (set*)malloc(sizeof(set)*set_cnt);
    size_t * addr = 0x12345; size_t * SETMASK = 5(~DUL << set_exp);
    size_t set = (sizeof(tm))(addr&SETMASK) >> wpb.exp; | << wpb.exp;
    size_t tag = (size_t)(addr >> (set_exp + wpb_exp));

    for(int i = 0; i < set_cnt; i++){
        cache[i].block = (block)malloc(sizeof(block)*block_out);
        for (j){
            cache[i].block[i].dirty = false;
            "cacheSim[j].LRU" = 0;
        }
    }
    if(cache[set].block[i].dirty && block.tag = tag) {
        int hit ++;
        bool found = true;
    }
    return hit;
}
//Function to get total number of attempts
int totalCache (int BPS, vector<int> cacheSim) {
        int set_cnt = 1 << strtol(argv[2], NULL, 10);
    int block_cnt = atoi(BPS)^2;
    set * cache = (set*)malloc(sizeof(set)*set_cnt);
    size_t * addr = 0x12345; size_t * SETMASK = 5(~DUL << set_exp);
    size_t set = (sizeof(tm))(addr&SETMASK) >> wpb.exp; | << wpb.exp;
    size_t tag = (size_t)(addr >> (set_exp + wpb_exp));

    for(int i = 0; i < set_cnt; i++){
        cache[i].block = (block)malloc(sizeof(block)*block_out);
        for (j){
            cache[i].block[i].dirty = false;
            "cacheSim[j].LRU" = 0;
            int total++;
        }
    }
    return total;
}

return;
