function createTab(n1,n2){
		for (let n = n1; n <= n2; n++) {
            let str += "<tr>"; 
            str += "<td>" + n + "</td>" ;         
            str += "<td>" + Math.pow(n,2) + "</td>";   
            str += "<td>" + Math.pow(n,3) + "</td>"; 
            str += "</tr>"; 
        }
        return str; 
}