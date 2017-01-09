package translator.expressions.functions;

import translator.Expression;
import translator.expressions.Function;

public class NaturalLogarithm extends Function {

	public NaturalLogarithm(Expression expr) {
		super(expr);
	}

	@Override
	public String operation() {
		return "ln";
	}

}
