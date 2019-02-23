# Infinite_Series
## Gregory-Leibniz
This first program uses the famous Gregory-Leibniz series to calculate the value of pi. This series follows the sequence:

$\pi = 4(1 - \frac{1}{3} + \frac{1}{5} + \frac{1}{7} ... )$

Unfortunately, this series converges very slowly on the actual value of pi; it takes 300 terms just to get it correct to two decimal places!

The program asks the user for how many terms they would like to calculate. The upper limit seems to be 2 billion terms, before Java oddly breaks for some reason. 

## Nalikantha
The second program uses the superior series of Nalikantha. It converges on pi with far fewer terms. It follows the sequence

$\pi = 3 + \frac{4}{2 \times 3 \times 4} - \frac{4}{4 \times 5 \times 6} + \frac{4}{6 \times 7 \times 8} ...$

I plan to make more infinite series programs in the future, including one that uses a more efficent series to get pi. Then, I intend to use data on how the computer handles those calculations to calculate its processsing power. I have no idea how to do that, so it'll be off in the future.

## PiFast
The thrid program uses an algorithm from [PiFast](http://numbers.computation.free.fr/Constants/PiProgram/pifast.html) and is supposedly the fastest algorithm for computing $\pi$, as claimed on the website.

The algorithm follows the sequence

$\frac{426880\sqrt{10005}}{\pi} = \sum_{n \geq 0} \frac{(6n)!(545140134n+13591409)}{(n!)^3(3n)!(-640320)^{3n}}$

which can be derived to

$\pi = \frac{\sum_{n \geq 0} \frac{(6n)!(545140134n+13591409)}{(n!)^3(3n)!(-640320)^{3n}}}{426880\sqrt{10005}}$
