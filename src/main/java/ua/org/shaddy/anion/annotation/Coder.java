package ua.org.shaddy.anion.annotation;

import ua.org.shaddy.anion.streamtools.bitinputstream.BitInputStream;
import ua.org.shaddy.anion.streamtools.bitoutputstream.BitOutputStream;

public interface Coder {
	public Object decode(BitInputStream bis);
	public void encode(BitOutputStream bos, Object obj);
}
