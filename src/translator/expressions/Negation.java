package translator.expressions;

import translator.Expression;

public class Negation extends UnaryOperation {
	public Negation(Expression expr) {
		super(expr);
	}

	@Override
	public String operation() {
		return "-";
	}
}
