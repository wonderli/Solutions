#include <iostream>
#include <vector>
using namespace std;
class CircularBuffer{
    public:
        int size;
        int head;
        int tail;
        bool full;
        int usage;
        string *buffer;
        CircularBuffer(int n){
            size = n;
            buffer = new string[size];
            head = 0;
            tail = 0;
            full = false;
            usage = 0;
        }
};
void append(CircularBuffer &buffer, int a){
    for(int i = 0; i < a; i++){
        cin >> buffer.buffer[(buffer.tail + i) % (buffer.size)];
        buffer.usage++;
        if(buffer.usage > buffer.size){
            buffer.full = true;
            buffer.usage = buffer.size;
        }
    }
    buffer.tail = (buffer.tail + a) % buffer.size;
    if(buffer.full == true){
        buffer.head = buffer.tail;
    }
}
void list(CircularBuffer &buffer){
    //cout << "Head " << buffer.head << endl;
    //cout << "Tail " << buffer.tail << endl;
    if(buffer.head < buffer.tail){
        for(int i = buffer.head; i < buffer.tail; i++){
            cout << buffer.buffer[i] << endl;
        }
    }else{
        for(int i = buffer.head; i < buffer.size; i++){
            cout << buffer.buffer[i] << endl;
        }
        for(int i = 0; i < buffer.tail; i++){
            cout << buffer.buffer[i] << endl;
        }
    }
}
void remove(CircularBuffer &buffer, int r){
    if(buffer.size - buffer.head > r){
        buffer.head = buffer.head + r;
    }else{
        buffer.head = r - (buffer.size - buffer.head);
    }
    buffer.usage = (buffer.usage - r) < 0 ? 0 : buffer.usage - r;
    if(r > 0){
        buffer.full = false;
    }
}
int main(){
    int n = 0;
    cin >> n;
    char action;
    CircularBuffer buffer(n);
    while(cin >> action){
        switch (action){
            case 'A':
            {
                int a = 0;
                cin >> a;
                append(buffer, a);
                break;
            }
            case 'R':
            {
                int r = 0;
                cin >> r;
                remove(buffer, r);
                break;
            }
            case 'L':
            {
                list(buffer);
                break;
            }
            case 'Q':
                break;
        }
        if(action == 'Q')
            break;
    }

}
