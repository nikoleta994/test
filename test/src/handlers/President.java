package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver {
	private int costConsumables = 1000;
	private int costClerical = 2000;
	private int costGadgets = 3000;
	private int costGaming = 5000;
	private int costPC = 8000;

	@Override
	public void approve(int id, double cost, Type type) {
		if (canApprove(id, cost, type)) {
			System.out.println("President approved purchase with id " + id + " that costs " + cost);
			return;
		}

		System.out.println("Purchase with id " + id + " needs approval from higher position than President.");

		next.approve(id, cost, type);
	}

	@Override
	protected boolean canApprove(int id, double cost, Type type) {
		boolean result = false;

		if (type == Type.CONSUMABLES && cost <= costConsumables) {
			result = true;
			return result;
		} else if (type == Type.CLERICAL && cost <= costClerical) {
			result = true;
			return result;
		} else if (type == Type.GADGETS && cost <= costGadgets) {
			result = true;
			return result;
		} else if (type == Type.GAMING && cost <= costGaming) {
			result = true;
			return result;
		} else if (type == Type.PC && cost <= costPC) {
			result = true;
			return result;
		} else {
			result = false;
			return result;
		}
	}
}
