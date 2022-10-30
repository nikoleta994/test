package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver {
	private int costConsumables = 700;
	private int costClerical = 1500;
	private int costGadgets = 2000;
	private int costGaming = 4500;
	private int costPC = 6500;

	@Override
	public void approve(int id, double cost, Type type) {
		if (canApprove(id, cost, type)) {
			System.out.println("VicePresident approved purchase with id " + id + " that costs " + cost);
			return;
		}

		System.out.println("Purchase with id " + id + " needs approval from higher position than VicePresident.");
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
