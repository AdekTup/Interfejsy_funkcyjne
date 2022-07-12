package pl.strefakursow._5_gotowe_interfejsy_funkcyjne_supplier_i_consumer;

public class Order {

	private Long id;
	private Status status;

	private static long COUNTER = 0;

	public Order() {
		this.id = COUNTER;
		COUNTER ++;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nOrder{" +
			"id=" + id +
			", status=" + status +
			'}';
	}
}
