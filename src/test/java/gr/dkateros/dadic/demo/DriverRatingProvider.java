package gr.dkateros.dadic.demo;

public class DriverRatingProvider {

	DriverRating ratingOf(Person person) {
		switch (person.uid) {
		case "1":
			return DriverRating.OFFENSIVE;
		case "2":
			return DriverRating.MIXED;
		default:
			return DriverRating.DEFENSIVE;
		}
	}

}
