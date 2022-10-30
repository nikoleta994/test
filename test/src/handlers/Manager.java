package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {
	private int costConsumables = 300;
	private int costClerical = 500;
	private int costGadgets = 1000;
	private int costGaming = 3000;
	private int costPC = 5000;

	@Override
	public void approve(int id, double cost, Type type) {
		if (canApprove(id, cost, type)) {
			System.out.println("Manager approved purchase with id " + id + " that costs " + cost);
			return;
		}

		System.out.println("Purchase with id " + id + " needs approval from higher position than Manager.");
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
