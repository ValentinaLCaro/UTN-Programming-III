import type { IProduct, ICartItem } from '../types/product';

export const getCartItems = (): ICartItem[] => {
    const cart = localStorage.getItem('cart');
    return cart ? JSON.parse(cart) : [];
};

export const addProductToCart = (producto: IProduct): void => {
    const cart = getCartItems();
    const existingItem = cart.find(item => item.producto.id === producto.id);

    if (existingItem) {
        existingItem.cantidad += 1;
    } else {
        cart.push({ producto, cantidad: 1 });
    }

    localStorage.setItem('cart', JSON.stringify(cart));
};

export const getCartTotal = (): number => {
    const cart = getCartItems();
    return cart.reduce((total, item) => total + (item.producto.precio * item.cantidad), 0);
};
