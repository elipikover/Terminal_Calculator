import java.lang.ArithmeticException
import java.lang.Exception

// Calculator Function

fun calc(a: Double, b: Double, i: String): Double {
    var res2:Double = 0.0
    if (i == "+") {
        return   a + b
    } else if (i == "-") {
        return  a - b
    } else if (i == "/") {
        return  a / b
    } else if (i == "*") {
        return  a * b
    }
    return 0.0
}

//initialization of user input

fun resetCalculator(res:Double): String {
    println("Total=  $res ")
    println("\n" + "Enter your calculation : " + "\nType q to Quit\n")
    var user = readLine().toString()
    return user
}


fun getOper(userInput:String): List<String> {
    //Parse input to operators
    val str = userInput
    var operators = Regex("[-,+,*,/,%]+").findAll(str).map(MatchResult::value).toList()
//Display Just to see the working operators
//            println(numbers)
    return operators
}


fun getNum(userInput:String): List<Double> {
//Parse input to numbers
    val str = userInput
    var numbers = Regex("[0-9.0-9]+").findAll(str).map(MatchResult::value).toList()

//Display Just to see the working operators
//            println(operators)

    val nums = numbers.map { it.toDouble()
                    }
    return nums
}



fun main(vararg arg: String) {

//Initiate Result
    var res: Double = 0.0
    //Initialize counters
    var firstTime = true


//Run Calculator
    while (true) {
        var count: Int = 0
        try {
//Get User Input
            var userInput = resetCalculator(res)
//Case where user wrote Q to Quit
            if (userInput == "q") {
                println("Calculator has quit")
                break
//Case where user wrote AC to clear
            } else if (userInput.contains("AC")) {
                var userInput = resetCalculator(0.0)
//Case where no Operators at all
            } else if (("+" !in userInput) and ("-" !in userInput) and ("/" !in userInput) and ("*" !in userInput)) {
                try {
                    res = userInput.toDouble()
                    continue
                } catch (c: Exception) {
                    println("Don't type bullshit\n")
                }
//Case where user wrote operators
            } else {
                var operators = getOper(userInput)
                var nums = getNum(userInput)
//                println(nums)
//                println(operators)

                if (nums.size>1) {
                    for (i in operators) {
                        res = calc(nums[count], nums[count + 1], i)
                        count += 1
                    }
                } else if(nums.size<2){
                        res = calc(res, nums[count], operators[0])

                    }
                }

            }  catch (a:ArithmeticException){
                println("Cant Divide by zero")
        }
    }
}


