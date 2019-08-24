package learn;

import java.util.Scanner;

public class ConvertToWordsTest {

	public static void main(String[] args) {
		printBothInDigitsAndWords();

	}
	public static void printBothInDigitsAndWords(){
		Scanner input=new Scanner(System.in);//get input from the user
		String first="";//The first digit in the amount entered
		String second="";//The second digit in the amount entered
		String third="";//The third digit in the amount entered
		String firstDigitAfterDecimal="";//first digit after the decimal point
		String secondDigitAfterDecimal="";//The second digit after decimal point in the amount entered
		String cent="";//Representing cent of dollar
		int count=0;
		String regex="[1-9]{1}[0-9]{0,2}.{1}[0-9]{2}";//The regular expression provides that the amount to entered must begin with a non zero digit, and must also end with two digits after the decimal point. The input must not exceed six characters
		System.out.println("Enter the amount to cash out. Amount must be <1000\nwith a dot separating dollar from cent");
		String attempt=input.next();
		if(attempt.matches(regex)){//If the input matches the regular expression
			int[] rightOfDecimal=new int[2];//Array with length = 2, representing digits to the right of decimal point
			String []token=attempt.split("");//Split the characters entered into various characters
			StringBuilder asteriks=new StringBuilder();//A stringBuilder variable to hold the asterisks to be appended, if any, to the amount printed in digits 
			StringBuilder digits=new StringBuilder();//A stringBuilder variable to hold the number of digits to be printed according to user's input
			String []amount1=new String[6];//Array of length 6, to hold the characters entered by the user in response to the request to enter the amount to cash out.
			String[]amount=new String[token.length];//Another array performing the same function as the one above
			int[] leftOfDecimal=new int[token.length-3];//An array to hold the digit(s) left of the decimal point. The length of this array depends upon the user's input. If the user enter 123.88 for instance, the array length becomes 3 i.e 6-3. If the user enters 10.55, the length becomes 2 i.e 5-3
			int u=1;
			int v=0;
			for(String x:token){//The different split components of the variable token is assigned to variable x
			  
				if(token.length-u==1||token.length-u==0){//This is a basic condition provided to avert the storing of the decimal point as part of digits after the decimal point. Since the digits after the decimal point must always be 2, if token.length-u=1 or 0, then it is either pointing to second to the last or the last of the digit after the decimal point.  
					 
					int c=Integer.parseInt(x);//Convert the element from String character to integer character, the assign it to int variable c. 
					rightOfDecimal[v]=c;//Store in the rightOfDecimal array variable
					v++;
					
				}
			
				amount[count]=x;
				amount1[count]=x;
				count++;
				u++;
			}
			for(int k=0;k<amount1.length;k++){//If the the array is not completely filled with numbers, then append as many asterisks as are needed to complete the six character requirement for amount.
				if(amount1[k]==null)
					asteriks.append("*");
				else
					digits.append(amount1[k]);//append the values to the variable digits. These values are the values entered by the user. 
			}
			for(int i=0;i<amount.length-3;i++){//Use to get get all the digits left of the decimal point, as entered by the user
				int l=Integer.parseInt(amount[i]);//Parse the value to integer and assign to l variable 
				
				leftOfDecimal[i]=l;//Store the values in the array leftOfDecimal
				
			}
			if(amount.length==6){//All the expressions within the condition below must be invoked as long as the number of characters entered by the user is up to 6 characters
				switch(leftOfDecimal[0]){//Testing different possible values of the first character contained in the array leftOfDecimal
				                         //for instance, if the first character is 9, the variable "first" is assigned the String values Nine hundred
				case 9:
					String nine="Nine";
					first=nine.concat(" hundred");
					break;
				case 8:
					String eigth="Eight";
					first=eigth.concat(" hundred");
					break;
				case 7:
					String seven="Seven";
					first=seven.concat(" hundred");
					break;
				case 6:
					String six="Six";
					first=six.concat(" hundred");
					break;
				case 5:
					String five="Five";
					first=five.concat(" hundred");
					break;
				case 4:
					String four="Four";
					first=four.concat(" hundred");
					break;
				case 3:
					String three="Three";
					first=three.concat(" hundred");
					break;
				case 2:
					String two="Two";
					first=two.concat(" hundred");
					break;
				case 1:
					String one="One";
					first=one.concat(" hundred");
					break;
					
				}
				switch(leftOfDecimal[1]){//Testing different possible values of the second digits in the array leftOfDecimal
				                         //for instance, if the digit is 9, the variable "second" is assigned the String value Ninety
				case 9:
					String nine=" Ninety ";
					second=nine;
					break;
				case 8:
					String eigth=" Eighty ";
					second=eigth;
					break;
				case 7:
					String seven=" Seventy ";
					second=seven;
					break;
				case 6:
					String six=" Sixty ";
					second=six;
					break;
				case 5:  
					String five=" Fifty ";
					second=five;
					break;
				case 4:
					String four=" Forty ";
					second=four;
					break;
				case 3:
					String three=" Thirty ";
					second=three;
					break;
				case 2:
					String two=" Twenty ";
					second=two;
					break;
			        //It is important to note here about the non inclusion of the possible case "one". This is because if one occurs as the second value leftOfDecimal, it'll be impossible to quantify the value without knowing the value of the third digit leftOfDecimal
					//This situation is taken care of in another conditional if statement.
				}
				switch(leftOfDecimal[2]){//Testing different possible values of the third digit in the leftOfDecimal
				case 9:
					String nine="Nine";
					third=nine;
					break;
				case 8:
					String eigth="Eight";
					third=eigth;
					break;
				case 7:
					String seven="Seven";
					third=seven;
					break;
				case 6:
					String six="Six";
					third=six;
					break;
				case 5:
					String five="Five";
					third=five;
					break;
				case 4:
					String four="Four";
					third=four;
					break;
				case 3:
					String three="Three";
					third=three;
					break;
				case 2:
					String two="Two";
					third=two;
					break;
				case 1:
					String one="One";
					third=one;
					break;
				}
				if(leftOfDecimal[1]==1){//Here we provide code that must execute only when the second digit leftOfDecimal is "One".
					switch(leftOfDecimal[2]){//If the second digit leftOfDecimal is "0", then the variable "second" should be assigned the value "ten" and the variable "third" should notbe assigned any value
					case 0:
						second=" ten";
						third="";
						break;
					case 1:
						second=" eleven";
						third="";
						
						break;
						
					case 2:
						second=" twelve";
						third="";
						break;
					case 3:
						second=" thirteen";
						third="";
						break;
					case 4:
						second=" fourteen";
						third="";
						break;
					case 5:
						second=" fifteen";
						third="";
						break;
					case 6:
						second=" sixteen";
						third="";
						break;
					case 7:
						second=" seventeen";
						third="";
						break;
					case 8:
						second=" eighteen";
						third="";
						break;
					case 9:
						second=" nineteen";
						third="";
						break;
					
					}	
					}//End of if(leftOfDecimal[1]==1)
				else if(leftOfDecimal[1]==0){//The code below execute only if the second digit leftOfDeciml is 0
						switch(leftOfDecimal[2]){//If the third digit is 0,the variable "second" and "third" should not be assigned any value. Here the output depends only on the variable "first". For instance the value 900.54, the overall value left of decimal point depends on the numeric value of the first digit which is 9 in this case. Therefore the numeric value of 9 is Nine hundred  
						case 0:
							second="";
							third="";
							break;
						case 1://If the case is 1, then the variable "second" should not be assigned any value, but the variable "third"
							second="";
							third=" one";
							break;
						case 2:
							second="";
							third=" two";
							break;
						case 3:
							second="";
							third=" three";
							break;
						case 4:
							second="";
							third=" four";
							break;
						case 5:
							second="";
							third=" five";
							break;
						case 6:
							second="";
							third=" six";
							break;
						case 7:
							second="";
							third=" seven";
							break;
						case 8:
							second="";
							third=" eight";
							break;
						case 9:
							second="";
							third=" nine";
							break;
							
						}
					}
				} //End of if(amount.length==6)
			     else if(amount.length==5&&leftOfDecimal[0]!=1){//Tests when the elements contained in the amount variable is 5, and the digit is not 1
					switch(leftOfDecimal[0]){
					case 9:
						first="Ninety ";//is the case is 9, the variable "first" is assigned the String value "Ninety"
						break;
					case 8:
						first="Eighty ";
						break;
					case 7:
						first="Seventy ";
						break;
					case 6:
						first="Sixty ";
						break;
					case 5:
						first="Fifty ";
						break;
					case 4:
						first="Forty ";
						break;
					case 3:
						first="Thirty ";
						break;
					case 2:
						first="Twenty ";
						break;
					    //Note the absence of the case 1. This is because the possible presence of the "One", is not enough to decide the overall numeric value contained in the leftOfDecimal without knowing the the next digit
						
					}//End of switch(leftOfDecimal[0]
					switch(leftOfDecimal[1]){//Test the occurrence of different possible values of the second digit in leftOfDecimal 
					case 0:
						break;
					case 1:
						second="one ";
						break;
					case 2:
						second="two ";
						break;
					case 3:
						second="three ";
						break;
					case 4:
						second="four ";
						break;
					case 5:
						second="five ";
						break;
					case 6:
						second="six ";
						break;
					case 7:
						second="seven ";
						break;
					case 8:
						second="eigth ";
						break;
					case 9:
						second="nine ";
						break;
					}
				}// End of else if(amount.length==5&&leftOfDecimal[0]!=1)
			     else if(amount.length==5&&leftOfDecimal[0]==1){//Tests when there are five characters entered, and the first character left of decimal is 1 
					switch(leftOfDecimal[1]){//Test for different possible values occurring in the second digit left of the decimal point 
					case 0: //If the value is 0, the variable "first" is assigned the value "ten", while the variables "second" and "third" retain their default initials.
						first="ten ";
						break;
					case 1:
						first="eleven ";
						break;
					case 2:
						first="Twelve ";
						break;
					case 3:
						first="Thirteen ";
						break;
					case 4:
						first="Fourteen ";
						break;
					case 5:
						first="Fifteen ";
						break;
					case 6:
						first="Sixteen ";
						break;
					case 7:
						first="Seventeen ";
						break;
					case 8:
						first="Eighteen ";
						break;
					case 9:
						first="Nineteen ";
						break;
					
					}
				}//End of else if(amount.length==5&&leftOfDecimal[0]==1)
			     else if(amount.length==4){//Tests when there are 4 characters entered by the user
					switch(leftOfDecimal[0]){//Tests for different possible values of the first digit left of the decimal point
					case 1://If the value is 1, the variable "first" is assigned the value "one", while the variables "second" and "third" retain their the default initials
						first="one ";
						break;
					case 2:
						first="Two ";
						break;
					case 3:
						first="Three ";
						break;
					case 4:
						first="Four ";
						break;
					case 5:
						first="Five ";
						break;
					case 6:
						first="Six ";
						break;
					case 7:
						first="Seven ";
						break;
					case 8:
						first="Eight ";
						break;
					case 9:
						first="Nine ";
						break;
						
					}
				}//End of  else if(amount.length==4)
			if(rightOfDecimal[0]!=0){//Tests when the first digit right of the decimal point is any other value except 0
				switch(rightOfDecimal[0]){
				case 9:
					firstDigitAfterDecimal="9";//If the value is 9, the variable firstDigitAfterDecimal is assigned the value "9".
					break;
				case 8:
				    firstDigitAfterDecimal="8";
				    break;
				case 7:
					firstDigitAfterDecimal="7";
					break;
				case 6:
					firstDigitAfterDecimal="6";
					break;
				case 5:
					firstDigitAfterDecimal="5";
					break;
				case 4:
				    firstDigitAfterDecimal="4";
				    break;
				case 3:
					firstDigitAfterDecimal="3";
					break;
				case 2:
					firstDigitAfterDecimal="2";
					break;
				case 1:
					firstDigitAfterDecimal="1";
					break;
				}
				switch(rightOfDecimal[1]){//Testing for different values of the second digit right of the decimal point
				case 0:
					secondDigitAfterDecimal="0";//If the value is 0, the variable secondDigitAfterDecimal is assigned the value 0
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");// firstDigitAfterDecimal and secondDigitAfterDecimal are divided by 100, then assigned to the variable "cent" which is the currency equivalent of cent
					break;
				case 1:
					secondDigitAfterDecimal="1";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				case 2:
					secondDigitAfterDecimal="2";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				case 3:
					secondDigitAfterDecimal="3";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				case 4:
					secondDigitAfterDecimal="4";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				case 5:
					secondDigitAfterDecimal="5";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				case 6:
					secondDigitAfterDecimal="6";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				case 7:
					secondDigitAfterDecimal="7";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				case 8:
					secondDigitAfterDecimal="8";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				case 9:
					secondDigitAfterDecimal="9";
					cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
					break;
				}
				}//End of if(rightOfDecimal[0]!=0)if(rightOfDecimal[0]!=0)
			  else if(rightOfDecimal[0]==0){//Test only when the first digit right of the decimal point is 0 
					switch(rightOfDecimal[1]){//Tests for different possible values of the second digit right of the decimal point
					case 0:
						firstDigitAfterDecimal="0";
						secondDigitAfterDecimal="0";
						cent=" dollar".concat(" AND ").concat(firstDigitAfterDecimal).concat(secondDigitAfterDecimal).concat(" cent");//If both the first and second digit right of the decimal point are 0, it will be awkward dividing the overall by 100 to get the cent currency equivalent as this should in the real life give a mathematical error.
						break;
					case 1:
						secondDigitAfterDecimal="1";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						
						break;
					case 2:
						secondDigitAfterDecimal="2";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						break;
					case 3:
						secondDigitAfterDecimal="3";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						break;
					case 4:
						secondDigitAfterDecimal="4";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						break;
					case 5:
						secondDigitAfterDecimal="5";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						break;
					case 6:
						secondDigitAfterDecimal="6";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						break;
					case 7:
						secondDigitAfterDecimal="7";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						break;
					case 8:
						secondDigitAfterDecimal="8";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						break;
					case 9:
						secondDigitAfterDecimal="9";
						cent=" dollar".concat(" AND ").concat(secondDigitAfterDecimal).concat("/100").concat(" cent");
						break;
					}
				}//End of if(rightOfDecimal[0]==0)
			    System.out.printf("%s%n%s:\t%s%n\t\t%s%n", "     Amount entered","In figure",asteriks.append(digits).toString(),"------");//Prints the amount entered in figure, adding asterisks if necessary.
				System.out.printf("%s:\t%s", "In words",first.concat(second).concat(third).concat(cent));//Prints the amount entered in words.
				}else 
					System.err.println("Cash not within the required or incorrect input.");//Executes only if the user's input fails the condition at line 267
			}

}
