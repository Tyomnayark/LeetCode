#include<iostream>

using namespace std;

template<typename T>
class Point {
    public: 
        Point(T x_, T y_) : x(x_), y(y_){}

        Point operator+(const Point& point) const {
            return Point(x + point.x, y + point.y);
        }

        Point operator*(T value) const {
            return Point(x * value, y * value);
        }

        friend istream& operator>>(istream& outStream, Point& point) {
            return outStream >> point.x >> point.y;
        }

        friend ostream& operator<<(ostream& inStream, const Point& point) {
            return inStream << "(" << point.x << ", " << point.y << ")";
        }

    private:
        T x, y;
};

int main() {
    Point<int> pointFirst(1, 2);
    Point<int> pointSecond(3.5, 4.3);

    cout << "pointFirst + pointSecond = " << pointFirst + pointSecond << endl;
    cout << "pointFirst * 3 = " << pointFirst * 3 << endl;

    cout << "Enter coordinates for point (x, y): ";
    cin >> pointFirst;

    cout << "pointFirst = " << pointFirst << endl;
    return 0;
}
