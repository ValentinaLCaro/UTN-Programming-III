const cargarCategorias = () => {
    const listaCategorias = document.getElementById("lista-categorias");

    categorias.forEach(categoria => {
        const li = document.createElement("li");
        const a = document.createElement("a");
        
        a.href = "#";
        a.textContent = categoria;

        li.appendChild(a);
        listaCategorias.appendChild(li);
    });
};

const cargarProductos = () => {
    const contenedorProductos = document.getElementById("contenedor-productos");

    productos.forEach(producto => {
        const article = document.createElement("article");

        article.innerHTML = `
            <img src="${producto.imagen}" alt="${producto.nombre}" width="250px">
            <h3>${producto.nombre}</h3>
            <p>${producto.descripcion}</p>
            <p>Precio: <strong>$${producto.precio.toFixed(2)}</strong></p>
            <button>Ver Detalles</button>
            <button class="btn-agregar">Agregar al Pedido</button>
        `;

        const btnAgregar = article.querySelector(".btn-agregar");
        btnAgregar.addEventListener("click", () => {
            alert(`Has agregado ${producto.nombre} al pedido.`);
        });

        contenedorProductos.appendChild(article);
    });
};

cargarCategorias();
cargarProductos();