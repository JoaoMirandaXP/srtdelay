// Generated from /home/jvcm/Documentos/srtdelay/src/main/java/resources/srt.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class srtParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, NUMBER=2, COLON=3, COMMA=4, ARROW=5, TIMESTAMP=6, TEXT=7;
	public static final int
		RULE_file_ = 0, RULE_subtitles = 1, RULE_subtitle = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"file_", "subtitles", "subtitle"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "':'", "','", "' --> '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "NUMBER", "COLON", "COMMA", "ARROW", "TIMESTAMP", "TEXT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "srt.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public srtParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_Context extends ParserRuleContext {
		public SubtitlesContext subtitles() {
			return getRuleContext(SubtitlesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(srtParser.EOF, 0); }
		public File_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_; }
	}

	public final File_Context file_() throws RecognitionException {
		File_Context _localctx = new File_Context(_ctx, getState());
		enterRule(_localctx, 0, RULE_file_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			subtitles();
			setState(7);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubtitlesContext extends ParserRuleContext {
		public List<SubtitleContext> subtitle() {
			return getRuleContexts(SubtitleContext.class);
		}
		public SubtitleContext subtitle(int i) {
			return getRuleContext(SubtitleContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(srtParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(srtParser.NEWLINE, i);
		}
		public SubtitlesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtitles; }
	}

	public final SubtitlesContext subtitles() throws RecognitionException {
		SubtitlesContext _localctx = new SubtitlesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subtitles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(9);
				subtitle();
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(10);
					match(NEWLINE);
					}
					}
					setState(15);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubtitleContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(srtParser.NUMBER, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(srtParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(srtParser.NEWLINE, i);
		}
		public TerminalNode TIMESTAMP() { return getToken(srtParser.TIMESTAMP, 0); }
		public List<TerminalNode> TEXT() { return getTokens(srtParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(srtParser.TEXT, i);
		}
		public SubtitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtitle; }
	}

	public final SubtitleContext subtitle() throws RecognitionException {
		SubtitleContext _localctx = new SubtitleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subtitle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(NUMBER);
			setState(21);
			match(NEWLINE);
			setState(22);
			match(TIMESTAMP);
			setState(23);
			match(NEWLINE);
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				match(TEXT);
				setState(26);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(25);
					match(NEWLINE);
					}
					break;
				}
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0007!\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\f\b\u0001\n\u0001\f\u0001\u000f\t\u0001\u0004\u0001"+
		"\u0011\b\u0001\u000b\u0001\f\u0001\u0012\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u001b\b\u0002\u0004"+
		"\u0002\u001d\b\u0002\u000b\u0002\f\u0002\u001e\u0001\u0002\u0000\u0000"+
		"\u0003\u0000\u0002\u0004\u0000\u0000!\u0000\u0006\u0001\u0000\u0000\u0000"+
		"\u0002\u0010\u0001\u0000\u0000\u0000\u0004\u0014\u0001\u0000\u0000\u0000"+
		"\u0006\u0007\u0003\u0002\u0001\u0000\u0007\b\u0005\u0000\u0000\u0001\b"+
		"\u0001\u0001\u0000\u0000\u0000\t\r\u0003\u0004\u0002\u0000\n\f\u0005\u0001"+
		"\u0000\u0000\u000b\n\u0001\u0000\u0000\u0000\f\u000f\u0001\u0000\u0000"+
		"\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000"+
		"\u000e\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u0010"+
		"\t\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0010"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0003"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0002\u0000\u0000\u0015\u0016"+
		"\u0005\u0001\u0000\u0000\u0016\u0017\u0005\u0006\u0000\u0000\u0017\u001c"+
		"\u0005\u0001\u0000\u0000\u0018\u001a\u0005\u0007\u0000\u0000\u0019\u001b"+
		"\u0005\u0001\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u001d\u0001\u0000\u0000\u0000\u001c\u0018"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u0005"+
		"\u0001\u0000\u0000\u0000\u0004\r\u0012\u001a\u001e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}