package models;

public class Medicamento {
	private int id;
	private String nombre;
	private String ppioActivo;
	private String fecha;
	private String tipo;
	private int cantidadActual;
	private double precio;

	// Modelo básico de medicamento

	public Medicamento(int id, String nombre, String ppioActivo, String fecha, String tipo, int cantidadActual,
			double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ppioActivo = ppioActivo;
		this.fecha = fecha;
		this.tipo = tipo;
		this.cantidadActual = cantidadActual;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPpioActivo() {
		return ppioActivo;
	}

	public void setPpioActivo(String ppioActivo) {
		this.ppioActivo = ppioActivo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void aumentarCantidadActual(int a) {
		this.cantidadActual += a;
	}
	
	public void disminuirCantidadActual(int a) {
		this.cantidadActual -= a;
	}

}
