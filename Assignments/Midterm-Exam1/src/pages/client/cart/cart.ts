import '../../../style.css';
import { verificarSesion, cerrarSesion } from '../../../utils/authGuard';
import { getCartItems, getCartTotal } from '../../../utils/cart';
import type { ICartItem } from '../../../types/product';

verificarSesion();

const btnLogout = document.getElementById('btn-logout');
btnLogout?.addEventListener('click', (e) => {
    e.preventDefault();
    cerrarSesion();
});

const contenedorCarrito = document.getElementById('contenedor-carrito') as HTMLElement;
const totalCarrito = document.getElementById('total-carrito') as HTMLHeadingElement;

const renderCarrito = () => {
    const items = getCartItems();
    contenedorCarrito.innerHTML = '';

    if (items.length === 0) {
        contenedorCarrito.innerHTML = '<p>El carrito está vacío.</p>';
        totalCarrito.textContent = '';
        return;
    }

    items.forEach((item: ICartItem) => {
        const div = document.createElement('div');
        div.className = 'cart-item';
        
        div.innerHTML = `
            <p><strong>${item.producto.nombre}</strong></p>
            <p>Precio unitario: $${item.producto.precio.toFixed(2)}</p>
            <p>Cantidad: ${item.cantidad}</p>
            <p>Subtotal: $${(item.producto.precio * item.cantidad).toFixed(2)}</p>
        `;
        
        contenedorCarrito.appendChild(div);
    });

    const total = getCartTotal();
    totalCarrito.textContent = `Total: $${total.toFixed(2)}`;
};

renderCarrito();
