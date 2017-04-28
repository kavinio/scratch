public enum ExpenseType {
PAST,
FUTURE_LOST_INCOME,
FUTURE_MEDICAL,
OTHERS;
	
	public static ExpenseType fromString(String text) {
		if (text != null) {
		      for (ExpenseType et : ExpenseType.values()) {
		        if (text.equalsIgnoreCase(et.toString())) {
		          return et;
		        }
		      }
		    }
		return null;
	}
}
