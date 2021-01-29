package main.dartanman.truechat.utils;

public class GrammarUtils {
	
	public static String fixContractions(String input) {
		String message = input;
		if(message.contains(" arent ")) {
			message = message.replace(" arent ", " aren't ");
		}
		if(message.contains(" cant ")) {
			message = message.replace(" cant ", " can't ");
		}
		if(message.contains(" couldve ")) {
			message = message.replace(" couldve ", " could've ");
		}
		if(message.contains(" couldnt ")) {
			message = message.replace(" couldnt ", " couldn't ");
		}
		if(message.contains(" didnt ")) {
			message = message.replace(" didnt ", " didn't ");
		}
		if(message.contains(" doesnt ")) {
			message = message.replace(" doesnt ", " doesn't ");
		}
		if(message.contains(" dont ")) {
			message = message.replace(" dont ", " don't ");
		}
		if(message.contains(" everybodys ")) {
			message = message.replace(" everybodys ", " everybody's ");
		}
		if(message.contains(" everyones ")) {
			message = message.replace(" everyones ", " everyone's ");
		}
		if(message.contains(" hadnt ")) {
			message = message.replace(" hadnt ", " hadn't ");
		}
		if(message.contains(" hasnt ")) {
			message = message.replace(" hasnt ", " hasn't ");
		}
		if(message.contains(" havent ")) {
			message = message.replace(" havent ", " haven't ");
		}
		if(message.contains(" hed ")) {
			message = message.replace(" hed ", " he'd ");
		}
		if(message.contains(" hes ")) {
			message = message.replace(" hes ", " he's ");
		}
		if(message.contains(" heres ")) {
			message = message.replace(" heres ", " here's ");
		}
		if(message.contains(" howd ")) {
			message = message.replace(" howd ", " how'd ");
		}
		if(message.contains(" hows ")) {
			message = message.replace(" hows ", " how's ");
		}
		if(message.contains(" im ")) {
			message = message.replace(" im ", " I'm ");
		}
		if(message.contains(" Im ")) {
			message = message.replace(" Im ", " I'm ");
		}
		if(message.contains(" ive ")) {
			message = message.replace(" ive ", " I've ");
		}
		if(message.contains(" Ive ")) {
			message = message.replace(" Ive ", " I've ");
		}
		if(message.contains(" isnt ")) {
			message = message.replace(" isnt ", " isn't ");
		}
		if(message.contains(" itd ")) {
			message = message.replace(" itd ", " it'd ");
		}
		if(message.contains(" itll ")) {
			message = message.replace(" itll ", " it'll ");
		}
		if(message.contains(" mightve ")) {
			message = message.replace(" mightve ", " might've ");
		}
		if(message.contains(" shes ")) {
			message = message.replace(" shes ", " she's ");
		}
		if(message.contains(" shouldve ")) {
			message = message.replace(" shouldve ", " should've ");
		}
		if(message.contains(" shouldnt ")) {
			message = message.replace(" shouldnt ", " shouldn't ");
		}
		if(message.contains(" somebodys ")) {
			message = message.replace(" somebodys ", " somebody's ");
		}
		if(message.contains(" someones ")) {
			message = message.replace(" someones ", " someone's ");
		}
		if(message.contains(" somethings ")) {
			message = message.replace(" somethings ", " something's ");
		}
		if(message.contains(" thatll ")) {
			message = message.replace(" thatll ", " that'll ");
		}
		if(message.contains(" thats ")) {
			message = message.replace(" thats ", " that's ");
		}
		if(message.contains(" thatd ")) {
			message = message.replace(" thatd ", " that'd ");
		}
		if(message.contains(" thered ")) {
			message = message.replace(" thered ", " there'd ");
		}
		if(message.contains(" therell ")) {
			message = message.replace(" therell ", " there'll ");
		}
		if(message.contains(" thats ")) {
			message = message.replace(" thats ", " that's ");
		}
		if(message.contains(" theseve ")) {
			message = message.replace(" theseve ", " these've ");
		}
		if(message.contains(" theyd ")) {
			message = message.replace(" theyd ", " they'd ");
		}
		if(message.contains(" theyll ")) {
			message = message.replace(" theyll ", " they'll ");
		}
		if(message.contains(" theyre ")) {
			message = message.replace(" theyre ", " they're ");
		}
		if(message.contains(" theyve ")) {
			message = message.replace(" theyve ", " they've ");
		}
		if(message.contains(" wasnt ")) {
			message = message.replace(" wasnt ", " wasn't ");
		}
		if(message.contains(" weve ")) {
			message = message.replace(" weve ", " we've ");
		}
		if(message.contains(" werent ")) {
			message = message.replace(" werent ", " weren't ");
		}
		if(message.contains(" whatd ")) {
			message = message.replace(" whatd ", " what'd ");
		}
		if(message.contains(" whatll ")) {
			message = message.replace(" whatll ", " what'll ");
		}
		if(message.contains(" whats ")) {
			message = message.replace(" whats ", " what's ");
		}
		if(message.contains(" whatve ")) {
			message = message.replace(" whatve ", " what've ");
		}
		if(message.contains(" whered ")) {
			message = message.replace(" whered ", " where'd ");
		}
		if(message.contains(" whod ")) {
			message = message.replace(" whod ", " who'd ");
		}
		if(message.contains(" wholl ")) {
			message = message.replace(" wholl ", " who'll ");
		}
		if(message.contains(" whos ")) {
			message = message.replace(" whos ", " who's ");
		}
		if(message.contains(" whyd ")) {
			message = message.replace(" whyd ", " why'd ");
		}
		if(message.contains(" wasnt ")) {
			message = message.replace(" wasnt ", " wasn't ");
		}
		if(message.contains(" wont ")) {
			message = message.replace(" wont ", " won't ");
		}
		if(message.contains(" wouldve ")) {
			message = message.replace(" wouldve ", " would've ");
		}
		if(message.contains(" wouldnt ")) {
			message = message.replace(" wouldnt ", " wouldn't ");
		}
		if(message.contains(" yall ")) {
			message = message.replace(" yall ", " y'all ");
		}
		if(message.contains(" youd ")) {
			message = message.replace(" youd ", " you'd ");
		}
		if(message.contains(" youll ")) {
			message = message.replace(" youll ", " you'll ");
		}
		if(message.contains("youre")) {
			message = message.replace("youre", "you're");
		}
		if(message.contains(" youve ")) {
			message = message.replace(" youve ", " you've ");
		}
		return message;
	}

}
