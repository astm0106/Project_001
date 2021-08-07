var path = './';
var e = document.createElement('span');
//e.innerHTML = '<a href="' + path + '"/>';
var msg = "前の画面に戻ります"

e.innerHTML = '<a href="' + path + '">' + msg + '</a>'; 

url = e.firstChild.href;
var p = url.split('/');

console.log("e.innerHTML: " + e.innerHTML);
console.log("url: " + url);
console.log("p: " + p);
console.log('/' + p[2]);

console.log(e.innerHTML.innerHTML);

document.getElementsByTagName('body')[0].appendChild(e);
