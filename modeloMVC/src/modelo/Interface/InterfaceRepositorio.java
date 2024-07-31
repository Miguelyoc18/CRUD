package modelo.Interface;

import java.util.List;

public interface InterfaceRepositorio<T> {
	public T recuperarID (int id);
	public List<T> recuperarTodo();
	public void agregar (T entidad);
	public void modificar (T entidad);
	public void eliminar (T entidad);
}
