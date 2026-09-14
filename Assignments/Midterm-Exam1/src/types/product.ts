export interface IProduct {
    id: number;
    nombre: string;
    descripcion: string;
    precio: number;
    imagen: string;
    categoria: string;
}

export interface ICartItem {
    producto: IProduct;
    cantidad: number;
}
