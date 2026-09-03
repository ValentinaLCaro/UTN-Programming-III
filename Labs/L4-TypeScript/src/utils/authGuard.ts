import type {IUser} from '../types/user';

export const verificarSesion = () => {
    const currentPath = window.location.pathname;
    
    if (currentPath.includes('/auth/login.html') || currentPath.includes('/auth/registro.html')) {
        return;
    }

    const sessionStorage = localStorage.getItem('userData');
    
    if (!sessionStorage) {
        alert("Debes iniciar sesión para acceder a esta página.");
        window.location.href = '../auth/login.html';
        return; 
    }

    const currentUser: IUser = JSON.parse(sessionStorage);

    if (currentPath.includes('/admin/') && currentUser.rol !== 'admin') {
        alert("Acceso denegado. No tienes permisos de administrador.");
        window.location.href = '/src/pages/client/index.html';
    }
};

export const cerrarSesion = () => {
    localStorage.removeItem('userData');
    window.location.href = '../auth/login.html';
};