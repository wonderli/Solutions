package main
import (
    "fmt"
    "math"
)
func checkPrime(num int) bool{
    for value := 2; value <= int(math.Sqrt(float64(num))); value++ {
        if(num % value == 0) {
            return false
        }
    }
    return true
}
func main(){
    count := 1
    sum := 2
    num := 3
    for count < 1000 {
        if(checkPrime(num) == true){
            sum += num
            count++
        }
        num++
    }
    fmt.Println(sum)
}
