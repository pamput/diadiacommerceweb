/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function aumentaDiUno(id){
    document.getElementById(id).value = document.getElementById(id).value - 1 + 2;

}

function decrementaDiUno(id){
    document.getElementById(id).value = document.getElementById(id).value - 1;

}

function calcoloParziale(id1, id2, r){
    var fat1 = document.getElementById(id1).value;
    var fat2 = document.getElementById(id2).value;
    var parziale = fat1 * fat2;
    document.getElementById(r).value = parziale;
    
}