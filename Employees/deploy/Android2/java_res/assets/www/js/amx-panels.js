(function(){function a(a,b){if(null==a)return b;var g=parseInt(a,10);return isNaN(g)?b:g}function b(){var a=arguments.length;2>a&&console.log("Not enough _ensureValidEnum arguments");for(var b=arguments[0],g=1;g<a;g++)if(b==arguments[g])return b;return arguments[1]}amx.registerRenderers("amx",{panelPage:{create:function(a){var b=document.createElement("div"),g=a.getRenderedChildren("primary"),h=a.getRenderedChildren("header"),k=a.getRenderedChildren("secondary"),m;if(g.length||h.length||k.length){var n=
document.createElement("div");n.className="amx-panelPage-header";var o=document.createElement("section");o.className="amx-panelPage-header-appIcon";n.appendChild(o);if(h.length)for(m in o=document.createElement("div"),o.className="amx-panelPage-facet-header",o.setAttribute("role","heading"),n.appendChild(o),o=$(o),h)o.append(h[m].renderNode());h=!1;if(o=g.length){var q=document.createElement("section");q.className="amx-panelPage-facet-primary";n.appendChild(q);q=$(q);for(m in g){var s=g[m].renderNode();
null==s||0==s.length||(1==o&&-1!=adf.mf.internal.amx.getCSSClassNameIndex(s.get(0).className,"amx-commandButton-back")&&(h=!0),q.append(s))}}h&&adf.mf.internal.amx.addCSSClassName(n,"amx-panelPage-header-primaryIsBack");if(k.length)for(m in g=document.createElement("section"),g.className="amx-panelPage-facet-secondary",n.appendChild(g),g=$(g),k)g.append(k[m].renderNode());b.appendChild(n)}k=document.createElement("div");k.className="amx-panelPage-content amx-scrollable";b.appendChild(k);$(k).append(a.renderSubNodes());
a=a.getRenderedChildren("footer");if(a.length)for(m in k=document.createElement("footer"),k.className="amx-panelPage-footer",b.appendChild(k),n=document.createElement("div"),n.className="amx-panelPage-facet-footer",k.appendChild(n),k=$(n),a)k.append(a[m].renderNode());return b},postDisplay:function(a,b){var g=adf.mf.api.amx.getClientState(b.getId());if(null!=g)for(var h=a.childNodes,k=h.length-1;0<=k;k--){var m=h[k];if(-1!=adf.mf.internal.amx.getCSSClassNameIndex(m.className,"amx-panelPage-content")){h=
g.scrollLeft;null!=h&&(m.scrollLeft=h);g=g.scrollTop;null!=g&&(m.scrollTop=g);break}}},preDestroy:function(a,b){this._storeScrollPositions(a.jquery?a.get(0):a,b.getId())},_storeScrollPositions:function(a,b){for(var g=a.childNodes,h=g.length-1;0<=h;h--){var k=g[h];if(-1!=adf.mf.internal.amx.getCSSClassNameIndex(k.className,"amx-panelPage-content")){g=k.scrollLeft;k=k.scrollTop;(null!=g||null!=k)&&adf.mf.api.amx.setClientState(b,{scrollLeft:g,scrollTop:k});break}}}},panelFormLayout:{create:function(a){var b=
document.createElement("div"),g=[];g.push("amx-panelFormLayout amx-scrollable");b.setAttribute("role","form");var h=document.createElement("div");h.className="amx-panelFormLayout_body";b.appendChild(h);var k="amx-label-position-start";null!=a.getAttribute("labelPosition")&&("end"===a.getAttribute("labelPosition")?k="amx-label-position-end":"center"===a.getAttribute("labelPosition")?k="amx-label-position-center":"topStart"===a.getAttribute("labelPosition")?k="amx-label-position-topStart":"topCenter"===
a.getAttribute("labelPosition")?k="amx-label-position-topCenter":"topEnd"===a.getAttribute("labelPosition")&&(k="amx-label-position-topEnd"));g.push(k);var m="amx-field-halign-end";null!=a.getAttribute("fieldHalign")&&("start"===a.getAttribute("fieldHalign")?m="amx-field-halign-start":"center"===a.getAttribute("fieldHalign")&&(m="amx-field-halign-center"));g.push(m);if("amx-label-position-topStart"!=k&&"amx-label-position-topCenter"!=k&&"amx-label-position-topEnd"!=k){g.push("amx-layout-one-row");
var n=document.createElement("div");n.className="amx-panelFormLayout_sizing";k=document.createElement("div");k.className="field-label";m=document.createElement("div");m.className="field-value";n.appendChild(k);n.appendChild(m);h.appendChild(n);n=a.getAttribute("labelWidth");this._nonNegativeNumberRegExp.test(n)&&(n+="px");var o=a.getAttribute("fieldWidth");this._nonNegativeNumberRegExp.test(o)&&(o+="px");var q=null==n?!1:n==this._nonNegativePercentRegExp.exec(n),s=null==o?!1:o==this._nonNegativePercentRegExp.exec(o),
t=!q&&(null==n?!1:n==this._nonNegativePxRegExp.exec(n)),u=!s&&(null==o?!1:o==this._nonNegativePxRegExp.exec(o));q&&s?(n=parseFloat(n),o=parseFloat(o),totalPercent=n+o,k.style.width=100*n/totalPercent+"%",m.style.width=100*o/totalPercent+"%"):t||t&&u?k.style.width=n:u&&(m.style.width=o)}else g.push("amx-layout-separate-rows");b.className=g.join(" ");$(h).append(a.renderSubNodes());return b},_nonNegativeNumberRegExp:RegExp(/^[0-9]+[.]?[0-9]*$/),_nonNegativePercentRegExp:RegExp(/[0-9]+[.]?[0-9]*[%]/),
_nonNegativePxRegExp:RegExp(/[0-9]+[.]?[0-9]*[p][x]/)},panelLabelAndMessage:function(a){var b=amx.createField(a),g=b.fieldRoot;g.setAttribute("aria-labelledby",a.getAttribute("label"));$(b.fieldValue).append(a.renderSubNodes());adf.mf.api.amx.applyRequiredMarker(a,b);return g},panelGroupLayout:function(a){var b,g;b=a.getAttribute("layout");var h="horizontal"===b,k="wrap"===b,m=!k?a.getAttribute("halign"):null,n=h?a.getAttribute("valign"):null;if(h){b=document.createElement("div");b.className="amx-scrollable";
var o=document.createElement("table");b.appendChild(o);g=o.insertRow(-1);"center"==m?o.setAttribute("align","center"):"end"==m&&(m=g.insertCell(-1),m.setAttribute("width","100%"))}else k?(b=document.createElement("span"),b.className="amx-scrollable amx-wrap"):(b=document.createElement("div"),b.className="amx-scrollable","center"==m?b.setAttribute("align","center"):"end"==m&&("rtl"==document.documentElement.dir?b.setAttribute("align","left"):b.setAttribute("align","right")));for(var a=a.renderSubNodes(),
o=0,q=a.length;o<q;++o){var s=a.get(o);h?(m=g.insertCell(-1),m.appendChild(s),("top"==n||"middle"==n||"bottom"==n)&&m.setAttribute("valign",n)):k?b.appendChild(s):(m=document.createElement("div"),m.appendChild(s),b.appendChild(m))}return b},tableLayout:function(d){var e=document.createElement("div");e.className="amx-scrollable";var g=document.createElement("table");g.setAttribute("border",a(d.getAttribute("borderWidth"),0));g.setAttribute("cellPadding",a(d.getAttribute("cellPadding"),0));g.setAttribute("cellSpacing",
a(d.getAttribute("cellSpacing"),0));var h=b(d.getAttribute("halign"),"start","center","end");"end"==h?"rtl"==document.documentElement.dir?g.setAttribute("align","left"):g.setAttribute("align","right"):"center"==h&&g.setAttribute("align",h);"fixed"==b(d.getAttribute("layout"),"fixed","weighted")&&(g.style.tableLayout="fixed");h=d.getAttribute("shortDesc");null!=h&&(g.title=h);h=d.getAttribute("summary");g.summary=null==h?"":h;h=d.getAttribute("width");null!=h&&(g.width=h);e.appendChild(g);for(var d=
d.renderSubNodes(),h=0,k=d.length;h<k;++h){var m=d.get(h);"TR"==m.tagName?g.appendChild(m):console.log("Illegal child found in tableLayout: "+m)}return e},rowLayout:function(a){for(var b=document.createElement("tr"),a=a.renderSubNodes(),g=0,h=a.length;g<h;++g){var k=a.get(g);"TD"==k.tagName?b.appendChild(k):"TH"==k.tagName?b.appendChild(k):console.log("Illegal child found in rowLayout: "+k)}return b},cellFormat:function(d){var e;e=d.getAttribute("header");e="true"===e||!0===e?document.createElement("th"):
document.createElement("td");var g=Math.max(1,a(d.getAttribute("columnSpan"),1));e.setAttribute("colspan",g);g=Math.max(1,a(d.getAttribute("rowSpan"),1));e.setAttribute("rowspan",g);g=b(d.getAttribute("halign"),"start","center","end");"end"==g?"rtl"==document.documentElement.dir?e.setAttribute("align","left"):e.setAttribute("align","right"):"center"==g?e.setAttribute("align",g):"rtl"==document.documentElement.dir?e.setAttribute("align","right"):e.setAttribute("align","left");g=b(d.getAttribute("valign"),
"middle","top","bottom");e.setAttribute("valign",g);g=d.getAttribute("shortDesc");null!=g&&(e.title=g);g=d.getAttribute("width");null!=g&&(e.width=g);g=d.getAttribute("height");null!=g&&(e.height=g);for(var d=d.renderSubNodes(),g=0,h=d.length;g<h;++g){var k=d.get(g);e.appendChild(k)}return e}})})();