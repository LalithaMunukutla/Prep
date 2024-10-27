//Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

class ValidParenthesisString{

	public static boolean validParenthesis(String s){
		//min: tracks min no.of unmatched '(' at any point
		//max: tracks max no.of unmatched '('
		int min=0,max=0;
		for(char ch: s.toCharArray()){
			if(ch=='('){
				min++;
				max++;
			}
			else if(ch=='*'){
				min--; //assuming * acts as ')'
				max++; //assuming * acts as '('
			}
			else if(ch==')'){
				min--;
				max--;
			}
			if(min<0){
				min =0;
			}
			if(max<0){
				return false;
			}
		}
		if(min==0){
			return true;
		}
		return false;
	}

	public static void main(String[] args){
		String s = "(*))";
		System.out.println(validParenthesis(s));
	}
}