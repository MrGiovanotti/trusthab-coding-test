1. I spent in the test about 6 hours, the most in the UI, sice I was a little rusty on making web interfaces and I wanted to practice a little.
   I think would add to my solution, maybe some validations, styles to my web iterface, pagination to my search results.

2. Although this was added in Java 8, I think the most useful feature for me has been Functional Programming and Lambdas. This saves you a lot of code and I also find it fun.

For Example:

Insted of doing this:

List<Integer> getEvenNumbers(List<Integer> numbers) {
  List<Integer> evenNumbers = new ArrayList<>();
  for (number : numbers) {
    if (number % 2 == 0) {
      evenNumbers.add(number);
    }
  }
  return evenNumbers;
}

You can do this:

List<Integer> getEvenNumbers(List<Integer> numbers) {
  return numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
}

3. In fact, I have had that problem in my job. What we usually do is connect to the Production environment carefully and using a test user (We have some users in Production, specifically for tests) and make a minucious debug until we find the problem.

4. I would improve the API maybe securing it with Spring Security and JWT, and using a database instead a JSON file.

5.
{
	"name": "Giovanny Granda",
	"age": 38,
	"profession": "Computer Engineer",
	"programming_experience": [{
		"language": "Java",
		"years": 7,
		"observations": "Favorite language"
	}, {
		"languaje": "c#",
		"years": 3
	}, {
		"languaje": "Python",
		"years": 2
	}, {
		"languaje": "Dart",
		"years": 2,
		"observations": "Not professionally, just for hobbie"
	}],
	"hobbies": ["Playing guitar", "Playing videogames"],
	"strengths": ["Perseverance", "Wanting to always learn", "I like to solve problems"],
	"weaknessess": ["Difficulty managing time", "It takes me a while to get comfortable with new people"],
	"married": false,
	"have_a_girlfriend": true
}
