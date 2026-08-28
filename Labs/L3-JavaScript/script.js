// ===== Actividad 1 =====
// Ejercicio 1:
let texto = "Hola Mundo"
const numero = 13
let boolean = true
let lista = ["numeros", 1, 2, 3, 4]
let persona = { nombre: "Valentina", edad: 19}

console.log("Valores:")
console.log(texto)
console.log(numero)
console.log(boolean)
console.log(lista)
console.log(persona)

// Ejercicio 2: 
console.log("\nTipos:")
console.log(typeof texto)   
console.log(typeof numero)   
console.log(typeof boolean)  
console.log(typeof lista)
console.log(typeof persona)

// Ejercicio 3: 
// numero = 14  genera un error en la consola ya que al ser una constante no se puede modificar su valor

// ===== Actividad 2 =====
// Ejercicio 4: 
const a = 15
const b = 4

console.log("\nSuma:", a + b)         
console.log("Resta:", a - b)         
console.log("Multiplicación:", a * b) 
console.log("División:", a / b)        
console.log("Módulo (%):", a % b)

// Ejercicio 5: 
console.log("\nComparaciones:");

console.log('"5" == 5  ->', "5" == 5)   
console.log('"5" === 5 ->', "5" === 5) 

console.log('0 == false  ->', 0 == false)   
console.log('0 === false ->', 0 === false)

// Ejercicio 6: 
const n = 17;

if (n % 2 === 0) {
  console.log(`\nEl número ${n} es par.`)
} else {
  console.log(`\nEl número ${n} es impar.`)
}

// Ejercicio 7:
const lenguajes = ["JavaScript", "Python", "Java", "C++"]

console.log("\nRecorrido con for:");
for (let i = 0; i < lenguajes.length; i++) {
  console.log(`Índice ${i}: ${lenguajes[i]}`)
}

// Ejercicio 8:
console.log("\nConteo con while:");
let contador = 1;

while (contador <= 5) {
  console.log(contador)
  contador++
}