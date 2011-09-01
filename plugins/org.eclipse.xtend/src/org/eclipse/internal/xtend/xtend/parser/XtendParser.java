// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g 2011-08-24 08:47:38
 	
package org.eclipse.internal.xtend.xtend.parser; 
	
import java.util.ArrayList;
import java.util.List;

import org.eclipse.internal.xtend.expression.ast.*;
import org.eclipse.internal.xtend.xtend.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class XtendParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "StringLiteral", "IntLiteral", "Identifier", "EscapeSequence", "UnicodeEscape", "OctalEscape", "HexDigit", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "XPAND_TAG_OPEN", "XPAND_TAG_CLOSE", "'import'", "';'", "'extension'", "'reexport'", "'context'", "'#'", "'if'", "'ERROR'", "'WARNING'", "':'", "'around'", "'('", "','", "'*'", "')'", "'::'", "'private'", "'cached'", "'JAVA'", "'.'", "'create'", "'Collection'", "'List'", "'Set'", "'let'", "'='", "'->'", "'?'", "'then'", "'else'", "'switch'", "'{'", "'case'", "'default'", "'}'", "'||'", "'&&'", "'implies'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'/'", "'!'", "'GLOBALVAR'", "'new'", "'false'", "'true'", "'null'", "'typeSelect'", "'collect'", "'select'", "'selectFirst'", "'reject'", "'exists'", "'notExists'", "'sortBy'", "'forAll'", "'|'", "'['", "']'"
    };
    public static final int EOF=-1;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int StringLiteral=4;
    public static final int IntLiteral=5;
    public static final int Identifier=6;
    public static final int EscapeSequence=7;
    public static final int UnicodeEscape=8;
    public static final int OctalEscape=9;
    public static final int HexDigit=10;
    public static final int Letter=11;
    public static final int JavaIDDigit=12;
    public static final int WS=13;
    public static final int COMMENT=14;
    public static final int LINE_COMMENT=15;
    public static final int XPAND_TAG_OPEN=16;
    public static final int XPAND_TAG_CLOSE=17;

    // delegates
    // delegators


        public XtendParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public XtendParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return XtendParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g"; }


    	private ExtensionFactory factory;
    	public XtendParser(TokenStream stream, ExtensionFactory factory) {
    		this(stream);
    		this.factory = factory;
    	}
    	
    	protected Identifier id(Token t) {
    		if (t == null)
    			return null;
    		CommonToken ct = (CommonToken) t;
    		Identifier id = new Identifier(t.getText());
    		id.setStart(ct.getStartIndex());
    		id.setEnd(ct.getStopIndex());
    		id.setLine(ct.getLine());
    		return id;
    	}



    // $ANTLR start "file"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:43:1: file returns [ExtensionFile r] : (nsi= nsImport )* (exti= extImport )* (ext= extension | a= around | c= check )* EOF ;
    public ExtensionFile file() throws RecognitionException {
        ExtensionFile r = null;

        NamespaceImportStatement nsi = null;

        ExtensionImportStatement exti = null;

        Extension ext = null;

        Around a = null;

        Check c = null;


        List nsimports = new ArrayList(), extimports = new ArrayList(), extensions = new ArrayList(), arounds = new ArrayList(), checks = new ArrayList();
        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:44:155: ( (nsi= nsImport )* (exti= extImport )* (ext= extension | a= around | c= check )* EOF )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:45:2: (nsi= nsImport )* (exti= extImport )* (ext= extension | a= around | c= check )* EOF
            {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:45:2: (nsi= nsImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:45:3: nsi= nsImport
            	    {
            	    pushFollow(FOLLOW_nsImport_in_file51);
            	    nsi=nsImport();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      nsimports.add(nsi);
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:46:2: (exti= extImport )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:46:3: exti= extImport
            	    {
            	    pushFollow(FOLLOW_extImport_in_file61);
            	    exti=extImport();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      extimports.add(exti);
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:47:2: (ext= extension | a= around | c= check )*
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case Identifier:
                case 34:
                case 35:
                case 38:
                case 39:
                case 40:
                case 41:
                    {
                    alt3=1;
                    }
                    break;
                case 28:
                    {
                    alt3=2;
                    }
                    break;
                case 22:
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:47:3: ext= extension
            	    {
            	    pushFollow(FOLLOW_extension_in_file71);
            	    ext=extension();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      extensions.add(ext);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:47:42: a= around
            	    {
            	    pushFollow(FOLLOW_around_in_file81);
            	    a=around();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      arounds.add(a);
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:47:73: c= check
            	    {
            	    pushFollow(FOLLOW_check_in_file91);
            	    c=check();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      checks.add(c);
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_file99); if (state.failed) return r;
            if ( state.backtracking==0 ) {
               r = factory.createExtensionFile(nsimports,extimports,extensions,arounds,checks);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "file"


    // $ANTLR start "nsImport"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:52:1: nsImport returns [NamespaceImportStatement r] : 'import' t= type ';' ;
    public NamespaceImportStatement nsImport() throws RecognitionException {
        NamespaceImportStatement r = null;

        Identifier t = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:52:47: ( 'import' t= type ';' )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:53:2: 'import' t= type ';'
            {
            match(input,18,FOLLOW_18_in_nsImport117); if (state.failed) return r;
            pushFollow(FOLLOW_type_in_nsImport121);
            t=type();

            state._fsp--;
            if (state.failed) return r;
            if ( state.backtracking==0 ) {
              r = factory.createNsImport(t);
            }
            match(input,19,FOLLOW_19_in_nsImport125); if (state.failed) return r;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "nsImport"


    // $ANTLR start "extImport"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:56:1: extImport returns [ExtensionImportStatement r] : 'extension' t= type (exported= 'reexport' )? ';' ;
    public ExtensionImportStatement extImport() throws RecognitionException {
        ExtensionImportStatement r = null;

        Token exported=null;
        Identifier t = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:56:48: ( 'extension' t= type (exported= 'reexport' )? ';' )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:57:2: 'extension' t= type (exported= 'reexport' )? ';'
            {
            match(input,20,FOLLOW_20_in_extImport140); if (state.failed) return r;
            pushFollow(FOLLOW_type_in_extImport144);
            t=type();

            state._fsp--;
            if (state.failed) return r;
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:57:21: (exported= 'reexport' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:57:22: exported= 'reexport'
                    {
                    exported=(Token)match(input,21,FOLLOW_21_in_extImport149); if (state.failed) return r;

                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_extImport153); if (state.failed) return r;
            if ( state.backtracking==0 ) {
               r = factory.createExtensionFileImport(t,id(exported));
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "extImport"


    // $ANTLR start "check"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:60:1: check returns [Check ext] : 'context' t= type ( '#' f= identifier )? ( 'if' guard= expression )? (sev1= 'ERROR' | 'WARNING' ) msg= expression ':' expr= expression ';' ;
    public Check check() throws RecognitionException {
        Check ext = null;

        Token sev1=null;
        Identifier t = null;

        Identifier f = null;

        Expression guard = null;

        Expression msg = null;

        Expression expr = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:60:26: ( 'context' t= type ( '#' f= identifier )? ( 'if' guard= expression )? (sev1= 'ERROR' | 'WARNING' ) msg= expression ':' expr= expression ';' )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:2: 'context' t= type ( '#' f= identifier )? ( 'if' guard= expression )? (sev1= 'ERROR' | 'WARNING' ) msg= expression ':' expr= expression ';'
            {
            match(input,22,FOLLOW_22_in_check168); if (state.failed) return ext;
            pushFollow(FOLLOW_type_in_check172);
            t=type();

            state._fsp--;
            if (state.failed) return ext;
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:18: ( '#' f= identifier )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:19: '#' f= identifier
                    {
                    match(input,23,FOLLOW_23_in_check174); if (state.failed) return ext;
                    pushFollow(FOLLOW_identifier_in_check177);
                    f=identifier();

                    state._fsp--;
                    if (state.failed) return ext;

                    }
                    break;

            }

            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:37: ( 'if' guard= expression )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:38: 'if' guard= expression
                    {
                    match(input,24,FOLLOW_24_in_check182); if (state.failed) return ext;
                    pushFollow(FOLLOW_expression_in_check186);
                    guard=expression();

                    state._fsp--;
                    if (state.failed) return ext;

                    }
                    break;

            }

            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:62: (sev1= 'ERROR' | 'WARNING' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            else if ( (LA7_0==26) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ext;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:63: sev1= 'ERROR'
                    {
                    sev1=(Token)match(input,25,FOLLOW_25_in_check193); if (state.failed) return ext;

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:61:76: 'WARNING'
                    {
                    match(input,26,FOLLOW_26_in_check195); if (state.failed) return ext;

                    }
                    break;

            }

            pushFollow(FOLLOW_expression_in_check200);
            msg=expression();

            state._fsp--;
            if (state.failed) return ext;
            match(input,27,FOLLOW_27_in_check202); if (state.failed) return ext;
            pushFollow(FOLLOW_expression_in_check207);
            expr=expression();

            state._fsp--;
            if (state.failed) return ext;
            match(input,19,FOLLOW_19_in_check209); if (state.failed) return ext;
            if ( state.backtracking==0 ) {
              ext = factory.createCheck(t, f, guard, sev1!=null, msg, expr);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ext;
    }
    // $ANTLR end "check"


    // $ANTLR start "around"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:66:1: around returns [Around r] : 'around' pc= pointcut '(' (p= declaredParameterList ( ( ',' )? wildparams= '*' )? | wildparams= '*' )? ')' ':' expr= expression ';' ;
    public Around around() throws RecognitionException {
        Around r = null;

        Token wildparams=null;
        Identifier pc = null;

        List<DeclaredParameter> p = null;

        Expression expr = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:66:28: ( 'around' pc= pointcut '(' (p= declaredParameterList ( ( ',' )? wildparams= '*' )? | wildparams= '*' )? ')' ':' expr= expression ';' )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:5: 'around' pc= pointcut '(' (p= declaredParameterList ( ( ',' )? wildparams= '*' )? | wildparams= '*' )? ')' ':' expr= expression ';'
            {
            match(input,28,FOLLOW_28_in_around230); if (state.failed) return r;
            pushFollow(FOLLOW_pointcut_in_around234);
            pc=pointcut();

            state._fsp--;
            if (state.failed) return r;
            match(input,29,FOLLOW_29_in_around236); if (state.failed) return r;
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:30: (p= declaredParameterList ( ( ',' )? wildparams= '*' )? | wildparams= '*' )?
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier||(LA10_0>=39 && LA10_0<=41)) ) {
                alt10=1;
            }
            else if ( (LA10_0==31) ) {
                alt10=2;
            }
            switch (alt10) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:31: p= declaredParameterList ( ( ',' )? wildparams= '*' )?
                    {
                    pushFollow(FOLLOW_declaredParameterList_in_around241);
                    p=declaredParameterList();

                    state._fsp--;
                    if (state.failed) return r;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:55: ( ( ',' )? wildparams= '*' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=30 && LA9_0<=31)) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:56: ( ',' )? wildparams= '*'
                            {
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:56: ( ',' )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0==30) ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:56: ','
                                    {
                                    match(input,30,FOLLOW_30_in_around244); if (state.failed) return r;

                                    }
                                    break;

                            }

                            wildparams=(Token)match(input,31,FOLLOW_31_in_around249); if (state.failed) return r;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:67:80: wildparams= '*'
                    {
                    wildparams=(Token)match(input,31,FOLLOW_31_in_around257); if (state.failed) return r;

                    }
                    break;

            }

            match(input,32,FOLLOW_32_in_around261); if (state.failed) return r;
            match(input,27,FOLLOW_27_in_around263); if (state.failed) return r;
            pushFollow(FOLLOW_expression_in_around272);
            expr=expression();

            state._fsp--;
            if (state.failed) return r;
            match(input,19,FOLLOW_19_in_around274); if (state.failed) return r;
            if ( state.backtracking==0 ) {
               r = factory.createAround(pc,p,wildparams!=null,expr);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "around"


    // $ANTLR start "pointcut"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:72:1: pointcut returns [Identifier r] : (a= '*' | b= identifier ) (a1= '*' | b1= identifier | c1= '::' )* ;
    public Identifier pointcut() throws RecognitionException {
        Identifier r = null;

        Token a=null;
        Token a1=null;
        Token c1=null;
        Identifier b = null;

        Identifier b1 = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:72:34: ( (a= '*' | b= identifier ) (a1= '*' | b1= identifier | c1= '::' )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:73:2: (a= '*' | b= identifier ) (a1= '*' | b1= identifier | c1= '::' )*
            {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:73:2: (a= '*' | b= identifier )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            else if ( (LA11_0==Identifier) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:73:4: a= '*'
                    {
                    a=(Token)match(input,31,FOLLOW_31_in_pointcut302); if (state.failed) return r;
                    if ( state.backtracking==0 ) {
                      r = id(a);
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:74:4: b= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_pointcut311);
                    b=identifier();

                    state._fsp--;
                    if (state.failed) return r;
                    if ( state.backtracking==0 ) {
                      r = b;
                    }

                    }
                    break;

            }

            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:75:4: (a1= '*' | b1= identifier | c1= '::' )*
            loop12:
            do {
                int alt12=4;
                switch ( input.LA(1) ) {
                case 31:
                    {
                    alt12=1;
                    }
                    break;
                case Identifier:
                    {
                    alt12=2;
                    }
                    break;
                case 33:
                    {
                    alt12=3;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:75:6: a1= '*'
            	    {
            	    a1=(Token)match(input,31,FOLLOW_31_in_pointcut322); if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      if (r!=null)r.append(id(a1));
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:76:6: b1= identifier
            	    {
            	    pushFollow(FOLLOW_identifier_in_pointcut333);
            	    b1=identifier();

            	    state._fsp--;
            	    if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      if (r!=null)r.append(b1);
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:77:6: c1= '::'
            	    {
            	    c1=(Token)match(input,33,FOLLOW_33_in_pointcut344); if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      if (r!=null)r.append(id(c1));
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "pointcut"


    // $ANTLR start "extension"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:82:1: extension returns [Extension r] : ( (priv= 'private' )? (cached= 'cached' )? (rType= type )? name= identifier '(' (params= declaredParameterList )? ')' ':' ( 'JAVA' jt= javaType '.' m= identifier '(' (pt= javaType ( ',' pt= javaType )* )? ')' ';' | expr= expression ';' ) | (priv= 'private' )? create= 'create' rType= type (rtn= identifier )? name= identifier '(' (params= declaredParameterList )? ')' ':' expr= expression ';' );
    public Extension extension() throws RecognitionException {
        Extension r = null;

        Token priv=null;
        Token cached=null;
        Token create=null;
        Identifier rType = null;

        Identifier name = null;

        List<DeclaredParameter> params = null;

        Identifier jt = null;

        Identifier m = null;

        Identifier pt = null;

        Expression expr = null;

        Identifier rtn = null;


        List<Identifier> javaParamTypes=new ArrayList<Identifier>();
        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:82:102: ( (priv= 'private' )? (cached= 'cached' )? (rType= type )? name= identifier '(' (params= declaredParameterList )? ')' ':' ( 'JAVA' jt= javaType '.' m= identifier '(' (pt= javaType ( ',' pt= javaType )* )? ')' ';' | expr= expression ';' ) | (priv= 'private' )? create= 'create' rType= type (rtn= identifier )? name= identifier '(' (params= declaredParameterList )? ')' ':' expr= expression ';' )
            int alt23=2;
            switch ( input.LA(1) ) {
            case 34:
                {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==Identifier||LA23_1==35||(LA23_1>=39 && LA23_1<=41)) ) {
                    alt23=1;
                }
                else if ( (LA23_1==38) ) {
                    alt23=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
                }
                break;
            case Identifier:
            case 35:
            case 39:
            case 40:
            case 41:
                {
                alt23=1;
                }
                break;
            case 38:
                {
                alt23=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:2: (priv= 'private' )? (cached= 'cached' )? (rType= type )? name= identifier '(' (params= declaredParameterList )? ')' ':' ( 'JAVA' jt= javaType '.' m= identifier '(' (pt= javaType ( ',' pt= javaType )* )? ')' ';' | expr= expression ';' )
                    {
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:2: (priv= 'private' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==34) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:3: priv= 'private'
                            {
                            priv=(Token)match(input,34,FOLLOW_34_in_extension372); if (state.failed) return r;

                            }
                            break;

                    }

                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:20: (cached= 'cached' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==35) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:21: cached= 'cached'
                            {
                            cached=(Token)match(input,35,FOLLOW_35_in_extension379); if (state.failed) return r;

                            }
                            break;

                    }

                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:39: (rType= type )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>=39 && LA15_0<=41)) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==Identifier) ) {
                        int LA15_2 = input.LA(2);

                        if ( (LA15_2==Identifier||LA15_2==33) ) {
                            alt15=1;
                        }
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:40: rType= type
                            {
                            pushFollow(FOLLOW_type_in_extension386);
                            rType=type();

                            state._fsp--;
                            if (state.failed) return r;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_identifier_in_extension392);
                    name=identifier();

                    state._fsp--;
                    if (state.failed) return r;
                    match(input,29,FOLLOW_29_in_extension394); if (state.failed) return r;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:73: (params= declaredParameterList )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==Identifier||(LA16_0>=39 && LA16_0<=41)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:83:74: params= declaredParameterList
                            {
                            pushFollow(FOLLOW_declaredParameterList_in_extension399);
                            params=declaredParameterList();

                            state._fsp--;
                            if (state.failed) return r;

                            }
                            break;

                    }

                    match(input,32,FOLLOW_32_in_extension403); if (state.failed) return r;
                    match(input,27,FOLLOW_27_in_extension405); if (state.failed) return r;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:85:2: ( 'JAVA' jt= javaType '.' m= identifier '(' (pt= javaType ( ',' pt= javaType )* )? ')' ';' | expr= expression ';' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==36) ) {
                        alt19=1;
                    }
                    else if ( ((LA19_0>=StringLiteral && LA19_0<=Identifier)||LA19_0==24||LA19_0==29||(LA19_0>=39 && LA19_0<=42)||(LA19_0>=48 && LA19_0<=49)||LA19_0==63||(LA19_0>=65 && LA19_0<=79)) ) {
                        alt19=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:85:4: 'JAVA' jt= javaType '.' m= identifier '(' (pt= javaType ( ',' pt= javaType )* )? ')' ';'
                            {
                            match(input,36,FOLLOW_36_in_extension412); if (state.failed) return r;
                            pushFollow(FOLLOW_javaType_in_extension416);
                            jt=javaType();

                            state._fsp--;
                            if (state.failed) return r;
                            match(input,37,FOLLOW_37_in_extension418); if (state.failed) return r;
                            pushFollow(FOLLOW_identifier_in_extension422);
                            m=identifier();

                            state._fsp--;
                            if (state.failed) return r;
                            match(input,29,FOLLOW_29_in_extension424); if (state.failed) return r;
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:85:43: (pt= javaType ( ',' pt= javaType )* )?
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==Identifier) ) {
                                alt18=1;
                            }
                            switch (alt18) {
                                case 1 :
                                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:85:44: pt= javaType ( ',' pt= javaType )*
                                    {
                                    pushFollow(FOLLOW_javaType_in_extension428);
                                    pt=javaType();

                                    state._fsp--;
                                    if (state.failed) return r;
                                    if ( state.backtracking==0 ) {
                                      javaParamTypes.add(pt);
                                    }
                                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:85:81: ( ',' pt= javaType )*
                                    loop17:
                                    do {
                                        int alt17=2;
                                        int LA17_0 = input.LA(1);

                                        if ( (LA17_0==30) ) {
                                            alt17=1;
                                        }


                                        switch (alt17) {
                                    	case 1 :
                                    	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:85:82: ',' pt= javaType
                                    	    {
                                    	    match(input,30,FOLLOW_30_in_extension432); if (state.failed) return r;
                                    	    pushFollow(FOLLOW_javaType_in_extension436);
                                    	    pt=javaType();

                                    	    state._fsp--;
                                    	    if (state.failed) return r;
                                    	    if ( state.backtracking==0 ) {
                                    	      javaParamTypes.add(pt);
                                    	    }

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop17;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            match(input,32,FOLLOW_32_in_extension444); if (state.failed) return r;
                            match(input,19,FOLLOW_19_in_extension446); if (state.failed) return r;
                            if ( state.backtracking==0 ) {
                               r = factory.createJavaExtension(name,rType,params,jt,m,javaParamTypes, id(cached),id(priv));
                            }

                            }
                            break;
                        case 2 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:87:4: expr= expression ';'
                            {
                            pushFollow(FOLLOW_expression_in_extension456);
                            expr=expression();

                            state._fsp--;
                            if (state.failed) return r;
                            match(input,19,FOLLOW_19_in_extension458); if (state.failed) return r;
                            if ( state.backtracking==0 ) {
                               r = factory.createExpressionExtension(name,rType,params,expr,  id(cached),id(priv)); 
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:91:3: (priv= 'private' )? create= 'create' rType= type (rtn= identifier )? name= identifier '(' (params= declaredParameterList )? ')' ':' expr= expression ';'
                    {
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:91:3: (priv= 'private' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==34) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:91:4: priv= 'private'
                            {
                            priv=(Token)match(input,34,FOLLOW_34_in_extension472); if (state.failed) return r;

                            }
                            break;

                    }

                    create=(Token)match(input,38,FOLLOW_38_in_extension478); if (state.failed) return r;
                    pushFollow(FOLLOW_type_in_extension482);
                    rType=type();

                    state._fsp--;
                    if (state.failed) return r;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:91:48: (rtn= identifier )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==Identifier) ) {
                        int LA21_1 = input.LA(2);

                        if ( (LA21_1==Identifier) ) {
                            alt21=1;
                        }
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:91:49: rtn= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_extension487);
                            rtn=identifier();

                            state._fsp--;
                            if (state.failed) return r;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_identifier_in_extension493);
                    name=identifier();

                    state._fsp--;
                    if (state.failed) return r;
                    match(input,29,FOLLOW_29_in_extension495); if (state.failed) return r;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:91:86: (params= declaredParameterList )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==Identifier||(LA22_0>=39 && LA22_0<=41)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:91:87: params= declaredParameterList
                            {
                            pushFollow(FOLLOW_declaredParameterList_in_extension500);
                            params=declaredParameterList();

                            state._fsp--;
                            if (state.failed) return r;

                            }
                            break;

                    }

                    match(input,32,FOLLOW_32_in_extension504); if (state.failed) return r;
                    match(input,27,FOLLOW_27_in_extension506); if (state.failed) return r;
                    pushFollow(FOLLOW_expression_in_extension512);
                    expr=expression();

                    state._fsp--;
                    if (state.failed) return r;
                    match(input,19,FOLLOW_19_in_extension514); if (state.failed) return r;
                    if ( state.backtracking==0 ) {
                       r = factory.createCreateExtension(id(create),rType,rtn,name,params,expr,id(priv)); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "extension"


    // $ANTLR start "javaType"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:97:1: javaType returns [Identifier r] : i= identifier (d= '.' (i1= identifier | i2= 'Collection' | i3= 'List' | i4= 'Set' ) )* ;
    public Identifier javaType() throws RecognitionException {
        Identifier r = null;

        Token d=null;
        Token i2=null;
        Token i3=null;
        Token i4=null;
        Identifier i = null;

        Identifier i1 = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:97:34: (i= identifier (d= '.' (i1= identifier | i2= 'Collection' | i3= 'List' | i4= 'Set' ) )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:98:2: i= identifier (d= '.' (i1= identifier | i2= 'Collection' | i3= 'List' | i4= 'Set' ) )*
            {
            pushFollow(FOLLOW_identifier_in_javaType536);
            i=identifier();

            state._fsp--;
            if (state.failed) return r;
            if ( state.backtracking==0 ) {
              r = i;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:99:2: (d= '.' (i1= identifier | i2= 'Collection' | i3= 'List' | i4= 'Set' ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==37) ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==Identifier) ) {
                        int LA25_3 = input.LA(3);

                        if ( (LA25_3==30||LA25_3==32||LA25_3==37) ) {
                            alt25=1;
                        }


                    }
                    else if ( ((LA25_1>=39 && LA25_1<=41)) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:99:3: d= '.' (i1= identifier | i2= 'Collection' | i3= 'List' | i4= 'Set' )
            	    {
            	    d=(Token)match(input,37,FOLLOW_37_in_javaType545); if (state.failed) return r;
            	    if ( state.backtracking==0 ) {
            	      if (r!=null)r.append(id(d));
            	    }
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:99:41: (i1= identifier | i2= 'Collection' | i3= 'List' | i4= 'Set' )
            	    int alt24=4;
            	    switch ( input.LA(1) ) {
            	    case Identifier:
            	        {
            	        alt24=1;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt24=2;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt24=3;
            	        }
            	        break;
            	    case 41:
            	        {
            	        alt24=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return r;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt24) {
            	        case 1 :
            	            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:99:42: i1= identifier
            	            {
            	            pushFollow(FOLLOW_identifier_in_javaType551);
            	            i1=identifier();

            	            state._fsp--;
            	            if (state.failed) return r;
            	            if ( state.backtracking==0 ) {
            	              if (r!=null)r.append(i1);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:99:86: i2= 'Collection'
            	            {
            	            i2=(Token)match(input,39,FOLLOW_39_in_javaType557); if (state.failed) return r;
            	            if ( state.backtracking==0 ) {
            	              r.append(id(i2));
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:100:2: i3= 'List'
            	            {
            	            i3=(Token)match(input,40,FOLLOW_40_in_javaType566); if (state.failed) return r;
            	            if ( state.backtracking==0 ) {
            	              if (r!=null)r.append(id(i3));
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:100:46: i4= 'Set'
            	            {
            	            i4=(Token)match(input,41,FOLLOW_41_in_javaType572); if (state.failed) return r;
            	            if ( state.backtracking==0 ) {
            	              if (r!=null)r.append(id(i4));
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "javaType"


    // $ANTLR start "expression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:106:1: expression returns [Expression e] : x= letExpression ;
    public Expression expression() throws RecognitionException {
        Expression e = null;

        Expression x = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:106:34: (x= letExpression )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:107:2: x= letExpression
            {
            pushFollow(FOLLOW_letExpression_in_expression594);
            x=letExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "expression"


    // $ANTLR start "letExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:110:1: letExpression returns [Expression e] : ( 'let' v= identifier '=' varExpr= castedExpression ':' target= expression | x= castedExpression );
    public Expression letExpression() throws RecognitionException {
        Expression e = null;

        Identifier v = null;

        Expression varExpr = null;

        Expression target = null;

        Expression x = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:110:39: ( 'let' v= identifier '=' varExpr= castedExpression ':' target= expression | x= castedExpression )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==42) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=StringLiteral && LA26_0<=Identifier)||LA26_0==24||LA26_0==29||(LA26_0>=39 && LA26_0<=41)||(LA26_0>=48 && LA26_0<=49)||LA26_0==63||(LA26_0>=65 && LA26_0<=79)) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:111:4: 'let' v= identifier '=' varExpr= castedExpression ':' target= expression
                    {
                    match(input,42,FOLLOW_42_in_letExpression613); if (state.failed) return e;
                    pushFollow(FOLLOW_identifier_in_letExpression617);
                    v=identifier();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,43,FOLLOW_43_in_letExpression619); if (state.failed) return e;
                    pushFollow(FOLLOW_castedExpression_in_letExpression623);
                    varExpr=castedExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,27,FOLLOW_27_in_letExpression625); if (state.failed) return e;
                    pushFollow(FOLLOW_expression_in_letExpression629);
                    target=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =factory.createLetExpression(v,varExpr,target);
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:113:4: x= castedExpression
                    {
                    pushFollow(FOLLOW_castedExpression_in_letExpression642);
                    x=castedExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "letExpression"


    // $ANTLR start "castedExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:116:1: castedExpression returns [Expression e] : ( ( '(' type ')' castedExpression )=> '(' t= type ')' x= chainExpression | x= chainExpression );
    public Expression castedExpression() throws RecognitionException {
        Expression e = null;

        Identifier t = null;

        Expression x = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:116:41: ( ( '(' type ')' castedExpression )=> '(' t= type ')' x= chainExpression | x= chainExpression )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:117:5: ( '(' type ')' castedExpression )=> '(' t= type ')' x= chainExpression
                    {
                    match(input,29,FOLLOW_29_in_castedExpression673); if (state.failed) return e;
                    pushFollow(FOLLOW_type_in_castedExpression677);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,32,FOLLOW_32_in_castedExpression679); if (state.failed) return e;
                    pushFollow(FOLLOW_chainExpression_in_castedExpression683);
                    x=chainExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e = factory.createCast(t,x);
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:119:4: x= chainExpression
                    {
                    pushFollow(FOLLOW_chainExpression_in_castedExpression692);
                    x=chainExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "castedExpression"


    // $ANTLR start "chainExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:123:1: chainExpression returns [Expression e] : x= ifExpression ( '->' right= ifExpression )* ;
    public Expression chainExpression() throws RecognitionException {
        Expression e = null;

        Expression x = null;

        Expression right = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:123:41: (x= ifExpression ( '->' right= ifExpression )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:124:2: x= ifExpression ( '->' right= ifExpression )*
            {
            pushFollow(FOLLOW_ifExpression_in_chainExpression712);
            x=ifExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:124:25: ( '->' right= ifExpression )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==44) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:124:27: '->' right= ifExpression
            	    {
            	    match(input,44,FOLLOW_44_in_chainExpression718); if (state.failed) return e;
            	    pushFollow(FOLLOW_ifExpression_in_chainExpression722);
            	    right=ifExpression();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e =factory.createChainExpression(e,right);
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "chainExpression"


    // $ANTLR start "ifExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:127:1: ifExpression returns [Expression e] : (x= switchExpression ( '?' thenPart= switchExpression ':' elsePart= switchExpression )? | 'if' condition= switchExpression 'then' thenPart= switchExpression ( 'else' elsePart= expression )? );
    public Expression ifExpression() throws RecognitionException {
        Expression e = null;

        Expression x = null;

        Expression thenPart = null;

        Expression elsePart = null;

        Expression condition = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:127:38: (x= switchExpression ( '?' thenPart= switchExpression ':' elsePart= switchExpression )? | 'if' condition= switchExpression 'then' thenPart= switchExpression ( 'else' elsePart= expression )? )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=StringLiteral && LA31_0<=Identifier)||LA31_0==29||(LA31_0>=39 && LA31_0<=41)||(LA31_0>=48 && LA31_0<=49)||LA31_0==63||(LA31_0>=65 && LA31_0<=79)) ) {
                alt31=1;
            }
            else if ( (LA31_0==24) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:128:2: x= switchExpression ( '?' thenPart= switchExpression ':' elsePart= switchExpression )?
                    {
                    pushFollow(FOLLOW_switchExpression_in_ifExpression743);
                    x=switchExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:128:28: ( '?' thenPart= switchExpression ':' elsePart= switchExpression )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==45) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:128:29: '?' thenPart= switchExpression ':' elsePart= switchExpression
                            {
                            match(input,45,FOLLOW_45_in_ifExpression747); if (state.failed) return e;
                            pushFollow(FOLLOW_switchExpression_in_ifExpression751);
                            thenPart=switchExpression();

                            state._fsp--;
                            if (state.failed) return e;
                            match(input,27,FOLLOW_27_in_ifExpression753); if (state.failed) return e;
                            pushFollow(FOLLOW_switchExpression_in_ifExpression757);
                            elsePart=switchExpression();

                            state._fsp--;
                            if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                              e =factory.createIf(e,thenPart,elsePart);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:129:3: 'if' condition= switchExpression 'then' thenPart= switchExpression ( 'else' elsePart= expression )?
                    {
                    match(input,24,FOLLOW_24_in_ifExpression765); if (state.failed) return e;
                    pushFollow(FOLLOW_switchExpression_in_ifExpression769);
                    condition=switchExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,46,FOLLOW_46_in_ifExpression771); if (state.failed) return e;
                    pushFollow(FOLLOW_switchExpression_in_ifExpression775);
                    thenPart=switchExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:129:68: ( 'else' elsePart= expression )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==47) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:129:69: 'else' elsePart= expression
                            {
                            match(input,47,FOLLOW_47_in_ifExpression778); if (state.failed) return e;
                            pushFollow(FOLLOW_expression_in_ifExpression782);
                            elsePart=expression();

                            state._fsp--;
                            if (state.failed) return e;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      e =factory.createIf(condition,thenPart,elsePart);
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "ifExpression"


    // $ANTLR start "switchExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:133:1: switchExpression returns [Expression e=null] : ( 'switch' ( '(' pred= orExpression ')' )? '{' ( 'case' c= orExpression ':' v= orExpression )* 'default' ':' def= orExpression '}' | x= orExpression );
    public Expression switchExpression() throws RecognitionException {
        Expression e = null;

        Expression pred = null;

        Expression c = null;

        Expression v = null;

        Expression def = null;

        Expression x = null;


        List cases = new ArrayList();
        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:133:85: ( 'switch' ( '(' pred= orExpression ')' )? '{' ( 'case' c= orExpression ':' v= orExpression )* 'default' ':' def= orExpression '}' | x= orExpression )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==48) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=StringLiteral && LA34_0<=Identifier)||LA34_0==29||(LA34_0>=39 && LA34_0<=41)||LA34_0==49||LA34_0==63||(LA34_0>=65 && LA34_0<=79)) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:134:4: 'switch' ( '(' pred= orExpression ')' )? '{' ( 'case' c= orExpression ':' v= orExpression )* 'default' ':' def= orExpression '}'
                    {
                    match(input,48,FOLLOW_48_in_switchExpression809); if (state.failed) return e;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:134:13: ( '(' pred= orExpression ')' )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==29) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:134:14: '(' pred= orExpression ')'
                            {
                            match(input,29,FOLLOW_29_in_switchExpression812); if (state.failed) return e;
                            pushFollow(FOLLOW_orExpression_in_switchExpression818);
                            pred=orExpression();

                            state._fsp--;
                            if (state.failed) return e;
                            match(input,32,FOLLOW_32_in_switchExpression820); if (state.failed) return e;

                            }
                            break;

                    }

                    match(input,49,FOLLOW_49_in_switchExpression827); if (state.failed) return e;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:136:4: ( 'case' c= orExpression ':' v= orExpression )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==50) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:137:6: 'case' c= orExpression ':' v= orExpression
                    	    {
                    	    match(input,50,FOLLOW_50_in_switchExpression840); if (state.failed) return e;
                    	    pushFollow(FOLLOW_orExpression_in_switchExpression844);
                    	    c=orExpression();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    match(input,27,FOLLOW_27_in_switchExpression847); if (state.failed) return e;
                    	    pushFollow(FOLLOW_orExpression_in_switchExpression852);
                    	    v=orExpression();

                    	    state._fsp--;
                    	    if (state.failed) return e;
                    	    if ( state.backtracking==0 ) {
                    	      cases.add(factory.createCase(c, v));
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    match(input,51,FOLLOW_51_in_switchExpression870); if (state.failed) return e;
                    match(input,27,FOLLOW_27_in_switchExpression872); if (state.failed) return e;
                    pushFollow(FOLLOW_orExpression_in_switchExpression878);
                    def=orExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,52,FOLLOW_52_in_switchExpression883); if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e = factory.createSwitchExpression(pred,cases,def);
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:143:4: x= orExpression
                    {
                    pushFollow(FOLLOW_orExpression_in_switchExpression895);
                    x=orExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "switchExpression"


    // $ANTLR start "orExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:146:1: orExpression returns [Expression e] : x= andExpression (name= '||' r= andExpression )* ;
    public Expression orExpression() throws RecognitionException {
        Expression e = null;

        Token name=null;
        Expression x = null;

        Expression r = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:146:37: (x= andExpression (name= '||' r= andExpression )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:147:4: x= andExpression (name= '||' r= andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_orExpression915);
            x=andExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:147:28: (name= '||' r= andExpression )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==53) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:147:29: name= '||' r= andExpression
            	    {
            	    name=(Token)match(input,53,FOLLOW_53_in_orExpression922); if (state.failed) return e;
            	    pushFollow(FOLLOW_andExpression_in_orExpression926);
            	    r=andExpression();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e = factory.createBooleanOperation(id(name),e,r);
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "orExpression"


    // $ANTLR start "andExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:150:1: andExpression returns [Expression e] : x= impliesExpression (name= '&&' r= impliesExpression )* ;
    public Expression andExpression() throws RecognitionException {
        Expression e = null;

        Token name=null;
        Expression x = null;

        Expression r = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:150:39: (x= impliesExpression (name= '&&' r= impliesExpression )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:151:2: x= impliesExpression (name= '&&' r= impliesExpression )*
            {
            pushFollow(FOLLOW_impliesExpression_in_andExpression949);
            x=impliesExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:151:30: (name= '&&' r= impliesExpression )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==54) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:151:31: name= '&&' r= impliesExpression
            	    {
            	    name=(Token)match(input,54,FOLLOW_54_in_andExpression956); if (state.failed) return e;
            	    pushFollow(FOLLOW_impliesExpression_in_andExpression960);
            	    r=impliesExpression();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e = factory.createBooleanOperation(id(name),e,r);
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "andExpression"


    // $ANTLR start "impliesExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:154:1: impliesExpression returns [Expression e] : x= relationalExpression (name= 'implies' r= relationalExpression )* ;
    public Expression impliesExpression() throws RecognitionException {
        Expression e = null;

        Token name=null;
        Expression x = null;

        Expression r = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:154:42: (x= relationalExpression (name= 'implies' r= relationalExpression )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:155:2: x= relationalExpression (name= 'implies' r= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_impliesExpression982);
            x=relationalExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:155:33: (name= 'implies' r= relationalExpression )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==55) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:155:34: name= 'implies' r= relationalExpression
            	    {
            	    name=(Token)match(input,55,FOLLOW_55_in_impliesExpression989); if (state.failed) return e;
            	    pushFollow(FOLLOW_relationalExpression_in_impliesExpression993);
            	    r=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e = factory.createBooleanOperation(id(name),e,r);
            	    }

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "impliesExpression"


    // $ANTLR start "relationalExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:159:1: relationalExpression returns [Expression e] : x= additiveExpression (name= ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) r= additiveExpression )* ;
    public Expression relationalExpression() throws RecognitionException {
        Expression e = null;

        Token name=null;
        Expression x = null;

        Expression r = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:159:45: (x= additiveExpression (name= ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) r= additiveExpression )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:160:2: x= additiveExpression (name= ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) r= additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1017);
            x=additiveExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:161:2: (name= ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) r= additiveExpression )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=56 && LA38_0<=61)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:161:3: name= ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) r= additiveExpression
            	    {
            	    name=(Token)input.LT(1);
            	    if ( (input.LA(1)>=56 && input.LA(1)<=61) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_additiveExpression_in_relationalExpression1051);
            	    r=additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e = factory.createBinaryOperation(id(name),e,r);
            	    }

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "relationalExpression"


    // $ANTLR start "additiveExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:165:1: additiveExpression returns [Expression e] : x= multiplicativeExpression (name= ( '+' | '-' ) r= multiplicativeExpression )* ;
    public Expression additiveExpression() throws RecognitionException {
        Expression e = null;

        Token name=null;
        Expression x = null;

        Expression r = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:165:43: (x= multiplicativeExpression (name= ( '+' | '-' ) r= multiplicativeExpression )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:166:2: x= multiplicativeExpression (name= ( '+' | '-' ) r= multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1072);
            x=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:167:4: (name= ( '+' | '-' ) r= multiplicativeExpression )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=62 && LA39_0<=63)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:167:5: name= ( '+' | '-' ) r= multiplicativeExpression
            	    {
            	    name=(Token)input.LT(1);
            	    if ( (input.LA(1)>=62 && input.LA(1)<=63) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1091);
            	    r=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e = factory.createBinaryOperation(id(name),e,r);
            	    }

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "additiveExpression"


    // $ANTLR start "multiplicativeExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:170:1: multiplicativeExpression returns [Expression e] : x= unaryExpression (name= ( '*' | '/' ) r= unaryExpression )* ;
    public Expression multiplicativeExpression() throws RecognitionException {
        Expression e = null;

        Token name=null;
        Expression x = null;

        Expression r = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:170:48: (x= unaryExpression (name= ( '*' | '/' ) r= unaryExpression )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:171:2: x= unaryExpression (name= ( '*' | '/' ) r= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1110);
            x=unaryExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:172:2: (name= ( '*' | '/' ) r= unaryExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==31||LA40_0==64) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:172:3: name= ( '*' | '/' ) r= unaryExpression
            	    {
            	    name=(Token)input.LT(1);
            	    if ( input.LA(1)==31||input.LA(1)==64 ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return e;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1128);
            	    r=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	      e = factory.createBinaryOperation(id(name),e,r);
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "multiplicativeExpression"


    // $ANTLR start "unaryExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:176:1: unaryExpression returns [Expression e] : (x= infixExpression | name= '!' x= infixExpression | name= '-' x= infixExpression );
    public Expression unaryExpression() throws RecognitionException {
        Expression e = null;

        Token name=null;
        Expression x = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:176:40: (x= infixExpression | name= '!' x= infixExpression | name= '-' x= infixExpression )
            int alt41=3;
            switch ( input.LA(1) ) {
            case StringLiteral:
            case IntLiteral:
            case Identifier:
            case 29:
            case 39:
            case 40:
            case 41:
            case 49:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                {
                alt41=1;
                }
                break;
            case 65:
                {
                alt41=2;
                }
                break;
            case 63:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:177:2: x= infixExpression
                    {
                    pushFollow(FOLLOW_infixExpression_in_unaryExpression1149);
                    x=infixExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:178:3: name= '!' x= infixExpression
                    {
                    name=(Token)match(input,65,FOLLOW_65_in_unaryExpression1157); if (state.failed) return e;
                    pushFollow(FOLLOW_infixExpression_in_unaryExpression1161);
                    x=infixExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e = factory.createOperationCall(id(name),x);
                    }

                    }
                    break;
                case 3 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:179:3: name= '-' x= infixExpression
                    {
                    name=(Token)match(input,63,FOLLOW_63_in_unaryExpression1169); if (state.failed) return e;
                    pushFollow(FOLLOW_infixExpression_in_unaryExpression1173);
                    x=infixExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e = factory.createOperationCall(id(name),x);
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "unaryExpression"


    // $ANTLR start "infixExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:182:1: infixExpression returns [Expression e] : x= primaryExpression ( '.' op= featureCall )* ;
    public Expression infixExpression() throws RecognitionException {
        Expression e = null;

        Expression x = null;

        FeatureCall op = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:182:40: (x= primaryExpression ( '.' op= featureCall )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:183:2: x= primaryExpression ( '.' op= featureCall )*
            {
            pushFollow(FOLLOW_primaryExpression_in_infixExpression1191);
            x=primaryExpression();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:183:30: ( '.' op= featureCall )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==37) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:183:32: '.' op= featureCall
            	    {
            	    match(input,37,FOLLOW_37_in_infixExpression1197); if (state.failed) return e;
            	    pushFollow(FOLLOW_featureCall_in_infixExpression1201);
            	    op=featureCall();

            	    state._fsp--;
            	    if (state.failed) return e;
            	    if ( state.backtracking==0 ) {
            	       if (op!=null) { op.setTarget(e);e =op;}
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "infixExpression"


    // $ANTLR start "primaryExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:186:1: primaryExpression returns [Expression e] : (c= StringLiteral | x= featureCall | x= booleanLiteral | x= numberLiteral | x= nullLiteral | x= listLiteral | x= constructorCall | x= globalVarExpression | x= paranthesizedExpression );
    public Expression primaryExpression() throws RecognitionException {
        Expression e = null;

        Token c=null;
        Expression x = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:186:44: (c= StringLiteral | x= featureCall | x= booleanLiteral | x= numberLiteral | x= nullLiteral | x= listLiteral | x= constructorCall | x= globalVarExpression | x= paranthesizedExpression )
            int alt43=9;
            switch ( input.LA(1) ) {
            case StringLiteral:
                {
                alt43=1;
                }
                break;
            case Identifier:
            case 39:
            case 40:
            case 41:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                {
                alt43=2;
                }
                break;
            case 68:
            case 69:
                {
                alt43=3;
                }
                break;
            case IntLiteral:
                {
                alt43=4;
                }
                break;
            case 70:
                {
                alt43=5;
                }
                break;
            case 49:
                {
                alt43=6;
                }
                break;
            case 67:
                {
                alt43=7;
                }
                break;
            case 66:
                {
                alt43=8;
                }
                break;
            case 29:
                {
                alt43=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:187:4: c= StringLiteral
                    {
                    c=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primaryExpression1227); if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                       e = factory.createStringLiteral(id(c));
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:188:5: x= featureCall
                    {
                    pushFollow(FOLLOW_featureCall_in_primaryExpression1238);
                    x=featureCall();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;
                case 3 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:189:5: x= booleanLiteral
                    {
                    pushFollow(FOLLOW_booleanLiteral_in_primaryExpression1248);
                    x=booleanLiteral();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;
                case 4 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:190:5: x= numberLiteral
                    {
                    pushFollow(FOLLOW_numberLiteral_in_primaryExpression1258);
                    x=numberLiteral();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;
                case 5 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:191:5: x= nullLiteral
                    {
                    pushFollow(FOLLOW_nullLiteral_in_primaryExpression1268);
                    x=nullLiteral();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;
                case 6 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:192:5: x= listLiteral
                    {
                    pushFollow(FOLLOW_listLiteral_in_primaryExpression1278);
                    x=listLiteral();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;
                case 7 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:193:5: x= constructorCall
                    {
                    pushFollow(FOLLOW_constructorCall_in_primaryExpression1288);
                    x=constructorCall();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;
                case 8 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:194:5: x= globalVarExpression
                    {
                    pushFollow(FOLLOW_globalVarExpression_in_primaryExpression1298);
                    x=globalVarExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;
                case 9 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:195:5: x= paranthesizedExpression
                    {
                    pushFollow(FOLLOW_paranthesizedExpression_in_primaryExpression1308);
                    x=paranthesizedExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "primaryExpression"


    // $ANTLR start "paranthesizedExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:198:1: paranthesizedExpression returns [Expression e] : '(' x= expression ')' ;
    public Expression paranthesizedExpression() throws RecognitionException {
        Expression e = null;

        Expression x = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:198:48: ( '(' x= expression ')' )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:199:5: '(' x= expression ')'
            {
            match(input,29,FOLLOW_29_in_paranthesizedExpression1327); if (state.failed) return e;
            pushFollow(FOLLOW_expression_in_paranthesizedExpression1331);
            x=expression();

            state._fsp--;
            if (state.failed) return e;
            match(input,32,FOLLOW_32_in_paranthesizedExpression1333); if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =factory.createParanthesizedExpression(x);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "paranthesizedExpression"


    // $ANTLR start "globalVarExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:202:1: globalVarExpression returns [GlobalVarExpression e] : 'GLOBALVAR' name= identifier ;
    public GlobalVarExpression globalVarExpression() throws RecognitionException {
        GlobalVarExpression e = null;

        Identifier name = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:202:54: ( 'GLOBALVAR' name= identifier )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:203:5: 'GLOBALVAR' name= identifier
            {
            match(input,66,FOLLOW_66_in_globalVarExpression1353); if (state.failed) return e;
            pushFollow(FOLLOW_identifier_in_globalVarExpression1357);
            name=identifier();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e = factory.createGlobalVarExpression(name);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "globalVarExpression"


    // $ANTLR start "featureCall"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:205:1: featureCall returns [FeatureCall e] : (id1= identifier '(' (l= parameterList )? ')' | t= type | x= collectionExpression );
    public FeatureCall featureCall() throws RecognitionException {
        FeatureCall e = null;

        Identifier id1 = null;

        List<Expression> l = null;

        Identifier t = null;

        FeatureCall x = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:205:38: (id1= identifier '(' (l= parameterList )? ')' | t= type | x= collectionExpression )
            int alt45=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==29) ) {
                    alt45=1;
                }
                else if ( (LA45_1==EOF||LA45_1==19||(LA45_1>=25 && LA45_1<=27)||(LA45_1>=30 && LA45_1<=33)||LA45_1==37||(LA45_1>=44 && LA45_1<=47)||(LA45_1>=50 && LA45_1<=64)) ) {
                    alt45=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return e;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
                }
                break;
            case 39:
            case 40:
            case 41:
                {
                alt45=2;
                }
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                {
                alt45=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:206:2: id1= identifier '(' (l= parameterList )? ')'
                    {
                    pushFollow(FOLLOW_identifier_in_featureCall1375);
                    id1=identifier();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,29,FOLLOW_29_in_featureCall1377); if (state.failed) return e;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:206:21: (l= parameterList )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( ((LA44_0>=StringLiteral && LA44_0<=Identifier)||LA44_0==24||LA44_0==29||(LA44_0>=39 && LA44_0<=42)||(LA44_0>=48 && LA44_0<=49)||LA44_0==63||(LA44_0>=65 && LA44_0<=79)) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:206:22: l= parameterList
                            {
                            pushFollow(FOLLOW_parameterList_in_featureCall1382);
                            l=parameterList();

                            state._fsp--;
                            if (state.failed) return e;

                            }
                            break;

                    }

                    match(input,32,FOLLOW_32_in_featureCall1386); if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e = factory.createOperationCall(id1,l);
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:207:5: t= type
                    {
                    pushFollow(FOLLOW_type_in_featureCall1396);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =factory.createFeatureCall(t,null);
                    }

                    }
                    break;
                case 3 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:208:5: x= collectionExpression
                    {
                    pushFollow(FOLLOW_collectionExpression_in_featureCall1407);
                    x=collectionExpression();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =x;
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "featureCall"


    // $ANTLR start "listLiteral"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:211:1: listLiteral returns [Expression e] : '{' (l= parameterList )? '}' ;
    public Expression listLiteral() throws RecognitionException {
        Expression e = null;

        List<Expression> l = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:211:37: ( '{' (l= parameterList )? '}' )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:212:2: '{' (l= parameterList )? '}'
            {
            match(input,49,FOLLOW_49_in_listLiteral1424); if (state.failed) return e;
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:212:6: (l= parameterList )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=StringLiteral && LA46_0<=Identifier)||LA46_0==24||LA46_0==29||(LA46_0>=39 && LA46_0<=42)||(LA46_0>=48 && LA46_0<=49)||LA46_0==63||(LA46_0>=65 && LA46_0<=79)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:212:7: l= parameterList
                    {
                    pushFollow(FOLLOW_parameterList_in_listLiteral1429);
                    l=parameterList();

                    state._fsp--;
                    if (state.failed) return e;

                    }
                    break;

            }

            match(input,52,FOLLOW_52_in_listLiteral1433); if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e =factory.createListLiteral(l);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "listLiteral"


    // $ANTLR start "constructorCall"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:215:1: constructorCall returns [Expression e] : 'new' t= simpleType ;
    public Expression constructorCall() throws RecognitionException {
        Expression e = null;

        Identifier t = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:215:41: ( 'new' t= simpleType )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:216:2: 'new' t= simpleType
            {
            match(input,67,FOLLOW_67_in_constructorCall1450); if (state.failed) return e;
            pushFollow(FOLLOW_simpleType_in_constructorCall1454);
            t=simpleType();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
              e = factory.createConstructorCall(t);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "constructorCall"


    // $ANTLR start "booleanLiteral"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:220:1: booleanLiteral returns [Expression e=factory.createBooleanLiteral(id(input.LT(1)))] : ( 'false' | 'true' );
    public Expression booleanLiteral() throws RecognitionException {
        Expression e = factory.createBooleanLiteral(id(input.LT(1)));

        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:220:86: ( 'false' | 'true' )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:
            {
            if ( (input.LA(1)>=68 && input.LA(1)<=69) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return e;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "booleanLiteral"


    // $ANTLR start "nullLiteral"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:224:1: nullLiteral returns [Expression e=factory.createNullLiteral(id(input.LT(1)))] : 'null' ;
    public Expression nullLiteral() throws RecognitionException {
        Expression e = factory.createNullLiteral(id(input.LT(1)));

        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:224:80: ( 'null' )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:225:2: 'null'
            {
            match(input,70,FOLLOW_70_in_nullLiteral1489); if (state.failed) return e;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "nullLiteral"


    // $ANTLR start "numberLiteral"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:228:1: numberLiteral returns [Expression e] : (a= IntLiteral | a= IntLiteral b= '.' c= IntLiteral );
    public Expression numberLiteral() throws RecognitionException {
        Expression e = null;

        Token a=null;
        Token b=null;
        Token c=null;

        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:228:39: (a= IntLiteral | a= IntLiteral b= '.' c= IntLiteral )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==IntLiteral) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==37) ) {
                    int LA47_2 = input.LA(3);

                    if ( (LA47_2==IntLiteral) ) {
                        alt47=2;
                    }
                    else if ( (LA47_2==Identifier||(LA47_2>=39 && LA47_2<=41)||(LA47_2>=71 && LA47_2<=79)) ) {
                        alt47=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return e;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA47_1==EOF||LA47_1==19||(LA47_1>=25 && LA47_1<=27)||(LA47_1>=30 && LA47_1<=32)||(LA47_1>=44 && LA47_1<=47)||(LA47_1>=50 && LA47_1<=64)) ) {
                    alt47=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return e;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:229:4: a= IntLiteral
                    {
                    a=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_numberLiteral1508); if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =factory.createIntegerLiteral(id(a));
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:230:4: a= IntLiteral b= '.' c= IntLiteral
                    {
                    a=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_numberLiteral1517); if (state.failed) return e;
                    b=(Token)match(input,37,FOLLOW_37_in_numberLiteral1521); if (state.failed) return e;
                    c=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_numberLiteral1525); if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                      e =factory.createRealLiteral(id(a).append(id(b)).append(id(c)));
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "numberLiteral"


    // $ANTLR start "collectionExpression"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:233:1: collectionExpression returns [FeatureCall e] : (name= 'typeSelect' '(' t= type ')' | name= ( 'collect' | 'select' | 'selectFirst' | 'reject' | 'exists' | 'notExists' | 'sortBy' | 'forAll' ) '(' (var= identifier '|' )? x= expression ')' );
    public FeatureCall collectionExpression() throws RecognitionException {
        FeatureCall e = null;

        Token name=null;
        Identifier t = null;

        Identifier var = null;

        Expression x = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:233:47: (name= 'typeSelect' '(' t= type ')' | name= ( 'collect' | 'select' | 'selectFirst' | 'reject' | 'exists' | 'notExists' | 'sortBy' | 'forAll' ) '(' (var= identifier '|' )? x= expression ')' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==71) ) {
                alt49=1;
            }
            else if ( ((LA49_0>=72 && LA49_0<=79)) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:234:3: name= 'typeSelect' '(' t= type ')'
                    {
                    name=(Token)match(input,71,FOLLOW_71_in_collectionExpression1545); if (state.failed) return e;
                    match(input,29,FOLLOW_29_in_collectionExpression1549); if (state.failed) return e;
                    pushFollow(FOLLOW_type_in_collectionExpression1553);
                    t=type();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,32,FOLLOW_32_in_collectionExpression1555); if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                       e = factory.createTypeSelectExpression(id(name),t);
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:237:5: name= ( 'collect' | 'select' | 'selectFirst' | 'reject' | 'exists' | 'notExists' | 'sortBy' | 'forAll' ) '(' (var= identifier '|' )? x= expression ')'
                    {
                    name=(Token)input.LT(1);
                    if ( (input.LA(1)>=72 && input.LA(1)<=79) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return e;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,29,FOLLOW_29_in_collectionExpression1618); if (state.failed) return e;
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:244:19: (var= identifier '|' )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==Identifier) ) {
                        int LA48_1 = input.LA(2);

                        if ( (LA48_1==80) ) {
                            alt48=1;
                        }
                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:244:20: var= identifier '|'
                            {
                            pushFollow(FOLLOW_identifier_in_collectionExpression1623);
                            var=identifier();

                            state._fsp--;
                            if (state.failed) return e;
                            match(input,80,FOLLOW_80_in_collectionExpression1625); if (state.failed) return e;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expression_in_collectionExpression1631);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return e;
                    match(input,32,FOLLOW_32_in_collectionExpression1633); if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                       e = factory.createCollectionExpression(id(name),var,x);
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "collectionExpression"


    // $ANTLR start "declaredParameterList"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:250:1: declaredParameterList returns [List<DeclaredParameter> l = new ArrayList<DeclaredParameter>()] : dp= declaredParameter ( ',' dp1= declaredParameter )* ;
    public List<DeclaredParameter> declaredParameterList() throws RecognitionException {
        List<DeclaredParameter> l =  new ArrayList<DeclaredParameter>();

        DeclaredParameter dp = null;

        DeclaredParameter dp1 = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:250:97: (dp= declaredParameter ( ',' dp1= declaredParameter )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:251:2: dp= declaredParameter ( ',' dp1= declaredParameter )*
            {
            pushFollow(FOLLOW_declaredParameter_in_declaredParameterList1657);
            dp=declaredParameter();

            state._fsp--;
            if (state.failed) return l;
            if ( state.backtracking==0 ) {
              l.add(dp);
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:251:36: ( ',' dp1= declaredParameter )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==30) ) {
                    int LA50_1 = input.LA(2);

                    if ( (LA50_1==Identifier||(LA50_1>=39 && LA50_1<=41)) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:251:37: ',' dp1= declaredParameter
            	    {
            	    match(input,30,FOLLOW_30_in_declaredParameterList1661); if (state.failed) return l;
            	    pushFollow(FOLLOW_declaredParameter_in_declaredParameterList1665);
            	    dp1=declaredParameter();

            	    state._fsp--;
            	    if (state.failed) return l;
            	    if ( state.backtracking==0 ) {
            	      l.add(dp1);
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return l;
    }
    // $ANTLR end "declaredParameterList"


    // $ANTLR start "declaredParameter"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:254:1: declaredParameter returns [DeclaredParameter dp] : t= type name= identifier ;
    public DeclaredParameter declaredParameter() throws RecognitionException {
        DeclaredParameter dp = null;

        Identifier t = null;

        Identifier name = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:254:50: (t= type name= identifier )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:255:2: t= type name= identifier
            {
            pushFollow(FOLLOW_type_in_declaredParameter1685);
            t=type();

            state._fsp--;
            if (state.failed) return dp;
            pushFollow(FOLLOW_identifier_in_declaredParameter1689);
            name=identifier();

            state._fsp--;
            if (state.failed) return dp;
            if ( state.backtracking==0 ) {
              dp = factory.createDeclaredParameter(t,name);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return dp;
    }
    // $ANTLR end "declaredParameter"


    // $ANTLR start "parameterList"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:258:1: parameterList returns [List<Expression> list = new ArrayList<Expression>()] : a= expression ( ',' b= expression )* ;
    public List<Expression> parameterList() throws RecognitionException {
        List<Expression> list =  new ArrayList<Expression>();

        Expression a = null;

        Expression b = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:258:78: (a= expression ( ',' b= expression )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:259:5: a= expression ( ',' b= expression )*
            {
            pushFollow(FOLLOW_expression_in_parameterList1711);
            a=expression();

            state._fsp--;
            if (state.failed) return list;
            if ( state.backtracking==0 ) {
              list.add(a);
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:259:34: ( ',' b= expression )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==30) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:259:35: ',' b= expression
            	    {
            	    match(input,30,FOLLOW_30_in_parameterList1716); if (state.failed) return list;
            	    pushFollow(FOLLOW_expression_in_parameterList1720);
            	    b=expression();

            	    state._fsp--;
            	    if (state.failed) return list;
            	    if ( state.backtracking==0 ) {
            	      list.add(b);
            	    }

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "parameterList"


    // $ANTLR start "type"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:264:1: type returns [Identifier id] : (a= collectionType | b= simpleType );
    public Identifier type() throws RecognitionException {
        Identifier id = null;

        Identifier a = null;

        Identifier b = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:264:30: (a= collectionType | b= simpleType )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=39 && LA52_0<=41)) ) {
                alt52=1;
            }
            else if ( (LA52_0==Identifier) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return id;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:265:2: a= collectionType
                    {
                    pushFollow(FOLLOW_collectionType_in_type1746);
                    a=collectionType();

                    state._fsp--;
                    if (state.failed) return id;
                    if ( state.backtracking==0 ) {
                      id =a;
                    }

                    }
                    break;
                case 2 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:266:2: b= simpleType
                    {
                    pushFollow(FOLLOW_simpleType_in_type1756);
                    b=simpleType();

                    state._fsp--;
                    if (state.failed) return id;
                    if ( state.backtracking==0 ) {
                      id =b;
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "type"


    // $ANTLR start "collectionType"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:269:1: collectionType returns [Identifier id ] : cl= ( 'Collection' | 'List' | 'Set' ) (b= '[' id1= simpleType c= ']' )? ;
    public Identifier collectionType() throws RecognitionException {
        Identifier id = null;

        Token cl=null;
        Token b=null;
        Token c=null;
        Identifier id1 = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:269:42: (cl= ( 'Collection' | 'List' | 'Set' ) (b= '[' id1= simpleType c= ']' )? )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:270:3: cl= ( 'Collection' | 'List' | 'Set' ) (b= '[' id1= simpleType c= ']' )?
            {
            cl=(Token)input.LT(1);
            if ( (input.LA(1)>=39 && input.LA(1)<=41) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return id;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
              id = id(cl);
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:271:3: (b= '[' id1= simpleType c= ']' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==81) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:271:4: b= '[' id1= simpleType c= ']'
                    {
                    b=(Token)match(input,81,FOLLOW_81_in_collectionType1799); if (state.failed) return id;
                    pushFollow(FOLLOW_simpleType_in_collectionType1803);
                    id1=simpleType();

                    state._fsp--;
                    if (state.failed) return id;
                    c=(Token)match(input,82,FOLLOW_82_in_collectionType1807); if (state.failed) return id;
                    if ( state.backtracking==0 ) {
                       id.append(id(b));id.append(id1);id.append(id(c));
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "collectionType"


    // $ANTLR start "simpleType"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:274:1: simpleType returns [Identifier id] : x= identifier (d= '::' end= identifier )* ;
    public Identifier simpleType() throws RecognitionException {
        Identifier id = null;

        Token d=null;
        Identifier x = null;

        Identifier end = null;


        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:274:36: (x= identifier (d= '::' end= identifier )* )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:275:2: x= identifier (d= '::' end= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_simpleType1827);
            x=identifier();

            state._fsp--;
            if (state.failed) return id;
            if ( state.backtracking==0 ) {
              id =x;
            }
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:276:2: (d= '::' end= identifier )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==33) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:276:3: d= '::' end= identifier
            	    {
            	    d=(Token)match(input,33,FOLLOW_33_in_simpleType1835); if (state.failed) return id;
            	    pushFollow(FOLLOW_identifier_in_simpleType1839);
            	    end=identifier();

            	    state._fsp--;
            	    if (state.failed) return id;
            	    if ( state.backtracking==0 ) {
            	      id.append(id(d)); id.append(end);
            	    }

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "simpleType"


    // $ANTLR start "identifier"
    // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:279:1: identifier returns [Identifier r] : x= Identifier ;
    public Identifier identifier() throws RecognitionException {
        Identifier r = null;

        Token x=null;

        try {
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:279:35: (x= Identifier )
            // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:280:4: x= Identifier
            {
            x=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier1862); if (state.failed) return r;
            if ( state.backtracking==0 ) {
              r =id(x);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "identifier"

    // $ANTLR start synpred1_Xtend
    public void synpred1_Xtend_fragment() throws RecognitionException {   
        // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:117:5: ( '(' type ')' castedExpression )
        // /Users/thoms/Development/checkout/eclipse/org.eclipse.xpand/plugins/org.eclipse.xtend/src/org/eclipse/internal/xtend/xtend/parser/Xtend.g:117:6: '(' type ')' castedExpression
        {
        match(input,29,FOLLOW_29_in_synpred1_Xtend662); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred1_Xtend664);
        type();

        state._fsp--;
        if (state.failed) return ;
        match(input,32,FOLLOW_32_in_synpred1_Xtend666); if (state.failed) return ;
        pushFollow(FOLLOW_castedExpression_in_synpred1_Xtend668);
        castedExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Xtend

    // Delegated rules

    public boolean synpred1_Xtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Xtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\22\uffff";
    static final String DFA27_eofS =
        "\22\uffff";
    static final String DFA27_minS =
        "\1\4\1\0\20\uffff";
    static final String DFA27_maxS =
        "\1\117\1\0\20\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\16\uffff\1\1";
    static final String DFA27_specialS =
        "\1\uffff\1\0\20\uffff}>";
    static final String[] DFA27_transitionS = {
            "\3\2\21\uffff\1\2\4\uffff\1\1\11\uffff\3\2\6\uffff\2\2\15\uffff"+
            "\1\2\1\uffff\17\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "116:1: castedExpression returns [Expression e] : ( ( '(' type ')' castedExpression )=> '(' t= type ')' x= chainExpression | x= chainExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Xtend()) ) {s = 17;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_nsImport_in_file51 = new BitSet(new long[]{0x000003CC10540040L});
    public static final BitSet FOLLOW_extImport_in_file61 = new BitSet(new long[]{0x000003CC10500040L});
    public static final BitSet FOLLOW_extension_in_file71 = new BitSet(new long[]{0x000003CC10400040L});
    public static final BitSet FOLLOW_around_in_file81 = new BitSet(new long[]{0x000003CC10400040L});
    public static final BitSet FOLLOW_check_in_file91 = new BitSet(new long[]{0x000003CC10400040L});
    public static final BitSet FOLLOW_EOF_in_file99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_nsImport117 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_type_in_nsImport121 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_nsImport125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_extImport140 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_type_in_extImport144 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_21_in_extImport149 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_extImport153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_check168 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_type_in_check172 = new BitSet(new long[]{0x0000000007800000L});
    public static final BitSet FOLLOW_23_in_check174 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_check177 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_24_in_check182 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_check186 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_check193 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_26_in_check195 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_check200 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_check202 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_check207 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_check209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_around230 = new BitSet(new long[]{0x0000038080000040L});
    public static final BitSet FOLLOW_pointcut_in_around234 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_around236 = new BitSet(new long[]{0x0000038180000040L});
    public static final BitSet FOLLOW_declaredParameterList_in_around241 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_30_in_around244 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_around249 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31_in_around257 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_around261 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_around263 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_around272 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_around274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_pointcut302 = new BitSet(new long[]{0x0000038280000042L});
    public static final BitSet FOLLOW_identifier_in_pointcut311 = new BitSet(new long[]{0x0000038280000042L});
    public static final BitSet FOLLOW_31_in_pointcut322 = new BitSet(new long[]{0x0000038280000042L});
    public static final BitSet FOLLOW_identifier_in_pointcut333 = new BitSet(new long[]{0x0000038280000042L});
    public static final BitSet FOLLOW_33_in_pointcut344 = new BitSet(new long[]{0x0000038280000042L});
    public static final BitSet FOLLOW_34_in_extension372 = new BitSet(new long[]{0x0000038800000040L});
    public static final BitSet FOLLOW_35_in_extension379 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_type_in_extension386 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_extension392 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_extension394 = new BitSet(new long[]{0x0000038100000040L});
    public static final BitSet FOLLOW_declaredParameterList_in_extension399 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_extension403 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_extension405 = new BitSet(new long[]{0x8003079021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_36_in_extension412 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_javaType_in_extension416 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_extension418 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_extension422 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_extension424 = new BitSet(new long[]{0x0000038100000040L});
    public static final BitSet FOLLOW_javaType_in_extension428 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_extension432 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_javaType_in_extension436 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_32_in_extension444 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_extension446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_extension456 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_extension458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_extension472 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_extension478 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_type_in_extension482 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_extension487 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_extension493 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_extension495 = new BitSet(new long[]{0x0000038100000040L});
    public static final BitSet FOLLOW_declaredParameterList_in_extension500 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_extension504 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_extension506 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_extension512 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_extension514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_javaType536 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_javaType545 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_javaType551 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_39_in_javaType557 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_40_in_javaType566 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_41_in_javaType572 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_letExpression_in_expression594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_letExpression613 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_letExpression617 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_letExpression619 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_castedExpression_in_letExpression623 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_letExpression625 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_letExpression629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castedExpression_in_letExpression642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_castedExpression673 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_type_in_castedExpression677 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_castedExpression679 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_chainExpression_in_castedExpression683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_chainExpression_in_castedExpression692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExpression_in_chainExpression712 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_chainExpression718 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_ifExpression_in_chainExpression722 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_switchExpression_in_ifExpression743 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ifExpression747 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_switchExpression_in_ifExpression751 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ifExpression753 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_switchExpression_in_ifExpression757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ifExpression765 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_switchExpression_in_ifExpression769 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ifExpression771 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_switchExpression_in_ifExpression775 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ifExpression778 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_ifExpression782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_switchExpression809 = new BitSet(new long[]{0x0002000020000000L});
    public static final BitSet FOLLOW_29_in_switchExpression812 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_orExpression_in_switchExpression818 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_switchExpression820 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_switchExpression827 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_50_in_switchExpression840 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_orExpression_in_switchExpression844 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_switchExpression847 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_orExpression_in_switchExpression852 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_51_in_switchExpression870 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_switchExpression872 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_orExpression_in_switchExpression878 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_switchExpression883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpression_in_switchExpression895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpression_in_orExpression915 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_orExpression922 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_andExpression_in_orExpression926 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_impliesExpression_in_andExpression949 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_andExpression956 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_impliesExpression_in_andExpression960 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_impliesExpression982 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_impliesExpression989 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_relationalExpression_in_impliesExpression993 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1017 = new BitSet(new long[]{0x3F00000000000002L});
    public static final BitSet FOLLOW_set_in_relationalExpression1025 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1051 = new BitSet(new long[]{0x3F00000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1072 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_set_in_additiveExpression1082 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1091 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1110 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1118 = new BitSet(new long[]{0x8003038020000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1128 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_infixExpression_in_unaryExpression1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_unaryExpression1157 = new BitSet(new long[]{0x0002038020000070L,0x000000000000FFFCL});
    public static final BitSet FOLLOW_infixExpression_in_unaryExpression1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_unaryExpression1169 = new BitSet(new long[]{0x0002038020000070L,0x000000000000FFFCL});
    public static final BitSet FOLLOW_infixExpression_in_unaryExpression1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_infixExpression1191 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_infixExpression1197 = new BitSet(new long[]{0x0000038000000040L,0x000000000000FF80L});
    public static final BitSet FOLLOW_featureCall_in_infixExpression1201 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_primaryExpression1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_featureCall_in_primaryExpression1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_primaryExpression1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numberLiteral_in_primaryExpression1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nullLiteral_in_primaryExpression1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listLiteral_in_primaryExpression1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constructorCall_in_primaryExpression1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalVarExpression_in_primaryExpression1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paranthesizedExpression_in_primaryExpression1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_paranthesizedExpression1327 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_paranthesizedExpression1331 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_paranthesizedExpression1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_globalVarExpression1353 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_globalVarExpression1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_featureCall1375 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_featureCall1377 = new BitSet(new long[]{0x8003078121000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_parameterList_in_featureCall1382 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_featureCall1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_featureCall1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionExpression_in_featureCall1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_listLiteral1424 = new BitSet(new long[]{0x8013078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_parameterList_in_listLiteral1429 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_listLiteral1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_constructorCall1450 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_simpleType_in_constructorCall1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_booleanLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_nullLiteral1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntLiteral_in_numberLiteral1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntLiteral_in_numberLiteral1517 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_numberLiteral1521 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IntLiteral_in_numberLiteral1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_collectionExpression1545 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_collectionExpression1549 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_type_in_collectionExpression1553 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_collectionExpression1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionExpression1568 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_collectionExpression1618 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_identifier_in_collectionExpression1623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_collectionExpression1625 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_collectionExpression1631 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_collectionExpression1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaredParameter_in_declaredParameterList1657 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_declaredParameterList1661 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_declaredParameter_in_declaredParameterList1665 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_type_in_declaredParameter1685 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_declaredParameter1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_parameterList1711 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_parameterList1716 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_expression_in_parameterList1720 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_collectionType_in_type1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleType_in_type1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType1778 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_collectionType1799 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_simpleType_in_collectionType1803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_collectionType1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simpleType1827 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_simpleType1835 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_identifier_in_simpleType1839 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_Identifier_in_identifier1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred1_Xtend662 = new BitSet(new long[]{0x0000038000000040L});
    public static final BitSet FOLLOW_type_in_synpred1_Xtend664 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_synpred1_Xtend666 = new BitSet(new long[]{0x8003078021000070L,0x000000000000FFFEL});
    public static final BitSet FOLLOW_castedExpression_in_synpred1_Xtend668 = new BitSet(new long[]{0x0000000000000002L});

}