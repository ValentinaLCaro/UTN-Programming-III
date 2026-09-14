import '../../../style.css';
import { verificarSesion, cerrarSesion } from '../../../utils/authGuard';
import { PRODUCTS, getCategories } from '../../../data/data';
import { addProductToCart } from '../../../utils/cart';
import type { IProduct } from '../../../types/product';
import type { ICategoria } from '../../../types/categoria';

verificarSesion();

const btnLogout = document.getElementById('btn-logout');
btnLogout?.addEventListener('click', (e) => {
    e.preventDefault();
    cerrarSesion();
});

const listaCategorias = document.getElementById('lista-categorias') as HTMLUListElement;
const contenedorProductos = document.getElementById('contenedor-productos') as HTMLElement;
const inputBusqueda = document.getElementById('input-busqueda') as HTMLInputElement;

let currentCategory = 'Todas';
let currentSearch = '';

const renderCategorias = () => {
    const categorias = getCategories();
    listaCategorias.innerHTML = '';
    
    categorias.forEach((cat: ICategoria) => {
        const li = document.createElement('li');
        const a = document.createElement('a');
        a.href = '#';
        a.textContent = cat.nombre;
        
        a.addEventListener('click', (e) => {
            e.preventDefault();
            currentCategory = cat.nombre;
            renderProductos();
        });
        
        li.appendChild(a);
        listaCategorias.appendChild(li);
    });
};

const renderProductos = () => {
    contenedorProductos.innerHTML = '';
    
    const filtrados = PRODUCTS.filter((prod: IProduct) => {
        const coincideCategoria = currentCategory === 'Todas' || prod.categoria === currentCategory;
        const coincideBusqueda = prod.nombre.toLowerCase().includes(currentSearch.toLowerCase());
        return coincideCategoria && coincideBusqueda;
    });

    if (filtrados.length === 0) {
        contenedorProductos.innerHTML = '<p>No se encontraron productos.</p>';
        return;
    }

    filtrados.forEach((prod: IProduct) => {
        const article = document.createElement('article');
        
        article.innerHTML = `
            <img src="${prod.imagen}" alt="${prod.nombre}">
            <h3>${prod.nombre}</h3>
            <p>${prod.descripcion}</p>
            <p>Precio: <strong>$${prod.precio.toFixed(2)}</strong></p>
        `;
        
        const btnAgregar = document.createElement('button');
        btnAgregar.textContent = 'Agregar al Pedido';
        
        btnAgregar.addEventListener('click', () => {
            addProductToCart(prod);
            alert(`Agregado al carrito: ${prod.nombre}`);
        });

        article.appendChild(btnAgregar);
        contenedorProductos.appendChild(article);
    });
};

inputBusqueda?.addEventListener('input', (e) => {
    currentSearch = (e.target as HTMLInputElement).value;
    renderProductos();
});

renderCategorias();
renderProductos();
