package translator;

import org.antlr.v4.runtime.tree.ParseTree;

import parser.ExpressionBaseVisitor;
import parser.ExpressionParser.NumberExprContext;
import parser.ExpressionParser.OperationExprContext;
import parser.ExpressionParser.ParenthesisExprContext;
import parser.ExpressionParser.VariableExprContext;

public class ExpressionInterpreter extends ExpressionBaseVisitor<Expression> {
	
	private ExpressionInterpreter() {};
	private static final ExpressionInterpreter INTERPRETER = new ExpressionInterpreter();
	
	public static Expression interpretParseTree(ParseTree tree) {
		return INTERPRETER.visit(tree);
	}
	
	@Override
	public Expression visitNumberExpr(NumberExprContext ctx) {
		return Expression.getNumberExpression(ctx.getText());
	}
	
	@Override
	public Expression visitVariableExpr(VariableExprContext ctx) {
		return Expression.getVariableExpression(ctx.getText());
	}
	
	@Override
	public Expression visitParenthesisExpr(ParenthesisExprContext ctx) {
		return visit(ctx.expr());
	}
	
	@Override
	public Expression visitOperationExpr(OperationExprContext ctx) {
		Expression left = visit(ctx.left), right = visit(ctx.right);
		switch(ctx.op.getText()) {
		case "+":	return left.add(right);
		case "-":	return left.subtract(right);
		case "*":	return left.multiply(right);
		case "/":	return left.divide(right);
		case "^":	return left.pow(right);
		default:	throw new RuntimeException();
		}
	}

}
