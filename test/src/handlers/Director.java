package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {
	private int costConsumables = 500;
	private int costClerical = 1000;
	private int costGadgets = 1500;
	private int costGaming = 3500;
	private int costPC = 6000;

	@Override
	public void approve(int id, double cost, Type type) {
		if (canApprove(id, cost, type)) {
			System.out.println("Director approved purchase with id " + id + " that costs " + cost);
			return;
		}

		System.out.println("Purchase with id " + id + " needs approval from higher position than Director.");
		next.approve(id, cost, type);
	}

	@Override
	protected boolean canApprove(int id, double cost, Type type) {
		boolean result = false;

		switch (type) {
		case CONSUMABLES:
			if (cost <= costConsumables) {
				result = true;
				return result;
			} else {
				break;
			}
		case CLERICAL:
			if (cost <= costClerical) {
				result = true;
				return result;
			} else {
				break;
			}
		case GADGETS:
			if (cost <= costGadgets) {
				result = true;
				return result;
			} else {
				break;
			}
		case GAMING:
			if (cost <= costGaming) {
				result = true;
				return result;
			} else {
				break;
			}
		case PC:
			if (cost <= costPC) {
				result = true;
				return result;
			} else {
				break;
			}
		default:
			result = false;
			return result;
		}
		return result;
	}
}
