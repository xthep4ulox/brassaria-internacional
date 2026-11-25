const API="http://localhost:8080/api";
const safe=s=>String(s??"").replace(/[&<>"']/g,c=>({"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#39;"}[c]));
const date=s=>s?new Date(s+"T12:00:00").toLocaleDateString("pt-BR"):"";
async function carregar(){
 try{
  const [b,i,e]=await Promise.all([fetch(API+"/bebidas"),fetch(API+"/institucional"),fetch(API+"/eventos/recentes")]);
  if(!b.ok||!i.ok||!e.ok)throw Error("Falha ao consultar a API.");
  const bebidas=await b.json(), institucional=await i.json(), eventos=await e.json();
  document.querySelector("#lista-bebidas").innerHTML=bebidas.map((x,n)=>`<article class="card"><span class="meta">${safe(x.categoria)}</span><h3>${safe(x.nome)}</h3><p>${safe(x.descricao)}</p></article>`).join("")||"<p>Nenhuma bebida cadastrada.</p>";
  document.querySelector("#valores").innerHTML=[["Missão",institucional.missao],["Visão",institucional.visao],["Valores",institucional.valores]].map(x=>`<article class="card"><h3>${x[0]}</h3><p>${safe(x[1])}</p></article>`).join("");
  document.querySelector("#lista-eventos").innerHTML=eventos.map(x=>`<article class="card"><span class="meta">${date(x.dataEvento)} · ${safe(x.local)}</span><h3>${safe(x.titulo)}</h3><p>${safe(x.descricao)}</p></article>`).join("")||"<p>Nenhum evento publicado.</p>";
 }catch(err){["#lista-bebidas","#valores","#lista-eventos"].forEach(id=>document.querySelector(id).innerHTML="<p>Não foi possível carregar os dados. Verifique se o back-end está em execução.</p>");}
}carregar();