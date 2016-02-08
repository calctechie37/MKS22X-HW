public class Recursion{

    double epsilon = .000000001;
    
    public String name(){
	return "Chan, Patrick";
    }

    public double sqrt(double n){
	return sqrtHelper(n, n / 3.0);
    }

    public double sqrtHelper(double n, double guess){
	if (Math.abs((n - (guess * guess)) / n) < epsilon){
	    return guess;
	}
	return sqrtHelper(n, (n / guess + guess) / 2);
    }
}
    
