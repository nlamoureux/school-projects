#define ADDR_BITS 12
#define WORD_CNT (1 << 12)
#define BIN_SIZE (WORD_CNT * sizeof(tm_word))
#include <fstream>
#include <iostream>
#include <cstdlib>
#include "encodings.h"


int PC = 0x0;
tm_encoding IR;  = rand();
tm_encoding IR = ram[PC++]

tm_encoding ram[WORD_CNT] = { 0 };
bool alphabet[256] = { false };
bool equals_flag = false;
deque <cell> tape;
int head = 0;

typedef struct cell cell;
struct cell{
	bool is_blank;
	char letter;
};

void parse_options(int argc, char* argv[], ifstream& Y1X_ZYy, ifstream& Yz_YxZx3) {

	int a_cnt = 0;
	int d_cnt = 0;
	int v_cnt = 0;

	char* optarg;
	int optind = 1;

	while (optind < argc && (optarg = argv[optind]) && optarg[0] == '-') {

		if (strcmp(optarg, "-h") == 0 || strcmp(optarg, "--help") == 0) {
			print_program_usage();
			exit(EXIT_SUCCESS);
		}
		else if (strcmp(optarg, "-a") == 0 || strcmp(optarg, "--animate") == 0) {
			option_animate = true;
			a_cnt++;
		}
		else if (strcmp(optarg, "-d") == 0 || strcmp(optarg, "--debug") == 0) {
			option_debug = true;
			d_cnt++;
		}
		else if (strcmp(optarg, "-v") == 0 || strcmp(optarg, "--verbose") == 0) {
			option_animate = true;
			option_debug = true;
			option_verbose = true;
			v_cnt++;
		}
		else {
			print_program_usage();
			cerr << "Unknown option : " << optarg << endl;
			exit(1);
			break;
		}

		optind++;
	}
	if (optind != (argc - 2)) {
		print_program_usage();
		exit(1);
	}

	if (a_cnt > 1 || d_cnt > 1 || v_cnt > 1) {
		cerr << "Not sure what is intended by repeat flag usage..." << endl;
		print_program_usage();
	}

	/*
	 * Open binary and  tape files
	 */

	Y1X_ZYy.open(argv[optind], ifstream::binary);
	if (!Y1X_ZYy.is_open()) {
		cerr << "Could not open file :\"" << argv[optind] << "\"" << endl;
		exit(1);
	}

	optind++;

	Yz_YxZx3.open(argv[optind], ifstream::binary);
	if (!Yz_YxZx3.is_open()) {
		cerr << "Could not open file :\"" << argv[optind] << "\"" << endl;
		exit(1);
	}

	int n;
	int moves;
	switch (IR.generic.opcode) {
	case cmp:
		if (IR.cmp.oring) {

		}
		else { //cmp
			if (IR.cmp.blank) {
				equals_flag = tape[head].is_blank;
				moves = moves + 1;
			}
			else {
				if (tape[head].is_blank) {
					equals_flag = false;
					moves = moves + 1;
				}
				else {
					equals_flag = tape[head].letter == IR.cmp.letter;
					moves = moves + 1;
				}
			}
		}
		break;

	case alpha:
		alphabet[IR.alpha.letter] = true;
		break

	case move:
		if (IR.move.left)
			tape = tape[n - 1];
		moves = moves + 1;
	}
	else {
		if (IR.move.right)
			tape = tape[n + 1];
		moves = moves + 1;
	}
	break;
	case brac:
		if (IR.brac.eq || IR.bra)
			tape = tape[IR.brac.addr];
		moves = moves + 1;
}
	else {
	}
	break;
	case draw:
		if (IR.draw.blank) {
			tape[n] == (string)"BLANK";
			moves = moves + 1;
		}
		else {
			tape[n] == (char)IR.draw.letter;
			moves = moves + 1;
		}
		break;

	case end:
		if (IR.end.halt) {
			cout << "Program halted after " % d" moves." << (moves) << endl;
		}
		else (IR.end.fail) {
			cout << "Program failed after " % d" moves." << (moves) << endl;
		}
		break;
}
	return;
}
		