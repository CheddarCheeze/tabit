(function(){function a(a){b(a.data.viewElement,a.data.popupElement,a.data.alignElementId,a.data.align)}function b(a,b,e,g){var h=document.getElementById(e);null==h&&(h=a);var e=b.style,k=adf.mf.internal.amx.getComputedStyle(b),u=b.offsetWidth+parseInt(k.marginLeft,10)+parseInt(k.marginRight,10);u>a.offsetWidth?(e.left="0px",e.right="0px"):"rtl"==document.documentElement.dir?(u=d(adf.mf.internal.amx.getElementRight(h),u,a.offsetWidth),e.right=u+"px"):(u=d(adf.mf.internal.amx.getElementLeft(h),u,a.offsetWidth),
e.left=u+"px");b=b.offsetHeight+parseInt(k.marginTop,10)+parseInt(k.marginBottom,10);b>a.offsetHeight?(e.top="0px",e.bottom="0px"):(k=adf.mf.internal.amx.getComputedStyle(h),u=adf.mf.internal.amx.getElementTop(h),"before"==g?(a=d(a.offsetHeight-u+parseInt(k.marginTop,10),b,a.offsetHeight),e.bottom=a+"px"):"overlapBottom"==g?(a=d(a.offsetHeight-(u+h.offsetHeight+parseInt(k.marginBottom,10)),b,a.offsetHeight),e.bottom=a+"px"):(a="overlapTop"==g?d(u-parseInt(k.marginTop,10),b,a.offsetHeight):d(u+h.offsetHeight+
parseInt(k.marginBottom,10),b,a.offsetHeight),e.top=a+"px"))}function d(a,b,d){return 0>a?0:a+b>d?d-b:a}function e(a){var b=null;adf.mf.api.amx.getPageRootNode().visit(new adf.mf.api.amx.VisitContext,function(d,e){return a(e)?(b=e,adf.mf.api.amx.VisitResult.COMPLETE):adf.mf.api.amx.VisitResult.ACCEPT});return b}function g(a){return e(function(b){return a==b.getAttribute("id")})}function h(a,b){for(var d=a.childNodes,e=d.length,g=b.length,h=[],k=0,v=0;v<e&&k<g;++v)for(var w=d[v],x=0;x<g;++x)if(-1!=
adf.mf.internal.amx.getCSSClassNameIndex(w.className,b[x])){h[x]=w;++k;break}return h}function k(b,d){var e=b.getAttribute("data-screenId"),g=document.getElementById("bodyPage"),k=document.getElementById(e),e=adf.mf.internal.amx._getNonPrimitiveElementData(b,"amxNode");e.setAttributeResolvedValue("_renderPopup",!1);if(!d){var t=new adf.mf.internal.amx.AmxNodeUpdateArguments;t.setAffectedAttribute(e,"_renderPopup");adf.mf.internal.amx.markNodeForUpdate(t)}$(window).unbind("resize",a);setTimeout(function(){$(k).remove();
$(b).remove();h(g,["amx-view-container"])[0].setAttribute("aria-hidden","false")},300)}amx.processShowPopupBehavior=function(a,b){var d=b.getAttribute("popupId"),d=adf.mf.el.getLocalValue(d),e=b.getAttribute("alignId"),e=adf.mf.el.getLocalValue(e),h=b.getAttribute("align"),h=adf.mf.el.getLocalValue(h),k=g(d);null!=k&&(k.setAttributeResolvedValue("_showPopupAttributes",{popupId:d,alignId:e,align:h}),k.setAttributeResolvedValue("_renderPopup",!0),d=new adf.mf.internal.amx.AmxNodeUpdateArguments,d.setAffectedAttribute(k,
"_showPopupAttributes"),d.setAffectedAttribute(k,"_renderPopup"),adf.mf.internal.amx.markNodeForUpdate(d))};amx.processClosePopupBehavior=function(a,b){var d=b.getAttribute("popupId"),d=adf.mf.el.getLocalValue(d),e=null;null!=d&&(e=document.getElementById(d+"::popupElement"));if(null==e){var g=a.getId();amx.log.debug("No element with the closePopupBehavior popupId found: "+d+" so using the triggerNodeId="+g+" instead");for(d=document.getElementById(g);null!=d;){if(-1!=adf.mf.internal.amx.getCSSClassNameIndex(d.className,
"amx-popup")){e=d;break}d=d.parentNode}}null==e?amx.log.debug("No nearest popup found for closing"):k(e)};amx.registerRenderers("amx",{popup:{createChildrenNodes:function(a){a.getAttribute("_renderPopup")&&a.createStampedChildren(null,null,null);return!0},updateChildren:function(a,b){b.hasChanged("_renderPopup")&&a.getAttribute("_renderPopup")&&0==a.getChildren().length&&a.createStampedChildren(null,null,null);return 2==b.getSize()&&b.hasChanged("_renderPopup")&&b.hasChanged("_showPopupAttributes")?
adf.mf.api.amx.AmxNodeChangeResult.REFRESH:adf.mf.api.amx.AmxNodeChangeResult.RERENDER},create:function(a){var b=document.createElement("div");b.className="popup-holder";try{var d=a.getId(),e=document.getElementById(d+"::popupElement");null!=e&&(a.getAttribute("_renderPopup")?($(e).remove(),this._showPopup(a,!1)):k(e,!0))}catch(g){console.log(g)}return b},refresh:function(a){this._showPopup(a,!0)},_showPopup:function(d,n){var o=d.getAttribute("_showPopupAttributes"),q=o.alignId,o=o.align,s=document.getElementById("bodyPage"),
t=h(s,["amx-view-container"])[0],u=h(t,["amx-view"])[0],v=d.getId(),w=document.getElementById(v),x=document.createElement("div");adf.mf.internal.amx._setNonPrimitiveElementData(x,"amxNode",d);var y=v+"::popupElement";x.setAttribute("id",y);x.style.cssText=w.style.cssText;x.className=w.className;adf.mf.internal.amx.removeCSSClassName(x,"popup-holder");x.setAttribute("role","dialog");adf.mf.internal.amx.addCSSClassName(x,"amx-scrollable");$(x).append(d.renderSubNodes());v=null;null!=q&&""!=q&&(v=g(q));
null==v&&(v=e(function(a){a=a.getTag();return"http://xmlns.oracle.com/adf/mf/amx"==a.getNamespace()&&"view"==a.getName()}));var z=x.style;z.opacity="0";if(n){var A=function(a){a.preventDefault();a.stopPropagation()},q=document.createElement("div"),w=d.getAttribute("autoDismiss");amx.isValueTrue(w)&&(q.setAttribute("role","button"),q.setAttribute("tabindex","0"),w=adf.mf.resource.getInfoString("AMXInfoBundle","amx_popup_DISMISS_BUTTON_LABEL"),q.setAttribute("aria-label",w));q.className="popupTransparentScreen";
w=amx.uuid();d.setAttributeResolvedValue("_screenId",w);q.id=w;t.setAttribute("aria-hidden","true");s.appendChild(q);x.setAttribute("data-screenId",w);$(q).tap(function(a){A(a);a=d.getAttribute("autoDismiss");amx.isValueTrue(a)&&k(document.getElementById(y))});$(q).bind("click mouseup mousemove mousedown touchstart touchmove touchend",A);$(q).drag({start:A,drag:A,end:A})}else x.setAttribute("data-screenId",d.getAttribute("_screenId"));s.appendChild(x);s=v.getId();b(u,x,s,o);z.opacity="";if(n){var t=
d.getAttribute("animation"),v=!0,q=document.documentElement,w="rtl"==q.dir,E=300,E="slideUp"==t||"slideDown"==t?Math.max(300,q.clientHeight):Math.max(300,q.clientWidth);"slideUp"==t?z.webkitTransform="translate(0px,"+E+"px)":"slideDown"==t?z.webkitTransform="translate(0px,-"+E+"px)":"slideStart"==t?z.webkitTransform=w?"translate(-"+E+"px,0px)":"translate("+E+"px,0px)":"slideEnd"==t?z.webkitTransform=w?"translate("+E+"px,0px)":"translate(-"+E+"px,0px)":"slideLeft"==t?z.webkitTransform="translate("+
E+"px,0px)":"slideRight"==t?z.webkitTransform="translate(-"+E+"px,0px)":v=!1;v&&setTimeout(function(){adf.mf.internal.amx.addCSSClassName(x,"transitioning");z.webkitTransform="translate(0px,0px)";$(x).bind("webkitTransitionEnd",function(){adf.mf.internal.amx.removeCSSClassName(x,"transitioning");$(x).unbind("webkitTransitionEnd")})},0)}o={viewElement:u,popupElement:x,alignElementId:s,align:o};$(window).resize(o,a)}}});adf.mf.internal.amx.closePopups=function(){for(var a=document.getElementById("bodyPage"),
b=[],d=a.childNodes.length-1;0<=d;--d){var e=a.childNodes[d];if(-1!=adf.mf.internal.amx.getCSSClassNameIndex(e.className,"amx-popup")){b.push(e);break}}a=b.length;for(d=0;d<a;++d)k(b[d])}})();