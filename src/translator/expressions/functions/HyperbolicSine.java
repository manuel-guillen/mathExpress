package translator.expressions.functions;

import translator.Expression;
import translator.expressions.Function;

public class HyperbolicSine extends Function {

	public HyperbolicSine(Expression expr) {
		super(expr);
	}

	@Override
	public String operation() {
		return "sinh";
	}

}
