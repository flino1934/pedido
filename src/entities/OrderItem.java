package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	private Product product;

	public OrderItem() {

	}

	public OrderItem(Integer quantity, Double price, Product product) {
		
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public Double subTotal() {
		
		return price*quantity;
		
	}
	
	public String toString() {
		
		return "Name: "+product.getProductName()
		+"Price per unity:"+price
		+"Quantity :"+quantity;
		
	}

}
