// CS431 HW1.cpp: Nathan Lamoureux

/*This program is made to identify and output tokens from a file containing a simplistic made-up language.
It will print out each token, its program string, and its line number*/

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>

using namespace std;


int main(int argc, char *argv[]) {
     if(argc != 2) {
          cerr << "Provide a single filename." << endl;
          exit(EXIT_FAILURE);
     }

     ifstream f(argv[1], ios::binary | ios::ate);

     if(!f.is_open()) {
          perror("The file didn't open correctly");
          exit(EXIT_FAILURE);
     }

     iostream::pos_type size = f.tellg();
     char *buf = new char[size];
     f.seekg(0);

     // read the file all at once
     f.read(buf, size);
     f.close();

     int line_no = 1;
     for(int i = 0; i < size; i++) {
         if(buf[i] == '+'){
               cout << "Line " << line_no << ": PLUS " << buf[i] << "\n";
         }
         else if(buf[i] == '-'){
            cout << "Line " << line_no << ": HYPH " << buf[i] << "\n";
         }
         else if(buf[i] == '#'){
            cout << "Line " << line_no << ": COMM ";
            while( buf[i] !=  '\n' && buf[i] !=  '\r'){
               cout << buf[i];
               i++;
            }
            i = i-1;
            cout << "\n";
         }
         else if(buf[i] == 'i' && buf[i+1] == 's'){
            cout << "Line " << line_no << ": ASSI " << buf[i] <<  buf[i+1] << "\n";
            i++;
         }
         else if(buf[i] == 'p' && buf[i+1] == 'r' && buf[i+2] == 'i' && buf[i+3] == 'n' && buf[i+4] == 't' && buf[i+5] == ' '){
                cout << "Line " << line_no << ": PRNT ";
                while(buf[i] != ' '){
                   cout << buf[i];
                   i++;
                }
                cout << "\n";
         }
         else if(buf[i] == 'C' && buf[i+1] == 'c') {
            cout << "Line " << line_no << ": COMM ";
            while(buf[i] != 'c' ||  buf[i+1] != 'C') {
               cout << buf[i];
               i++;
            }
         cout << "cC \n";
         i = i+1;
         }
         else if(isdigit(buf[i])){
               cout << "Line " << line_no << ": NUMB ";
               while(isdigit(buf[i])){
               cout << buf[i];
               i++;
               }
         cout << "\n";
         i = i-1;
         }
         else if(islower(buf[i]) && (buf[i+1] == ' ' || buf[i+1] == '#' || buf[i+1] == '+' || buf[i+1] == '-' || buf[i+1] == '\r' || buf[i+1] == '\n')){
               cout << "Line " << line_no << ": VARI " << buf[i] << "\n";
         }
         else  if(buf[i] == '\n') {
               cout << "linux newl on line " << line_no << endl;
               line_no++;
         }
         else if(buf[i] == '\r') {
               if(i + 1 < size && buf[i + 1] == '\n') {
                    cout << "Windows newl on line " << line_no << endl;
                    i++;
               }
               else {
                    cout << "alternate newl on line " << line_no << endl;
               }
               line_no++;
         }
        else if(buf[i] == ' '){
        }
        else {
         cout << "Line " << line_no << ": HUH? ";
         while(buf[i] != ' ' || buf[i] != '+' || buf[i] != '-' || buf[i] != '#'){
         cout << buf[i];
         i++;
         }
        cout << "\n";
        }
     }
     delete[] buf;

     exit(EXIT_SUCCESS);
}
