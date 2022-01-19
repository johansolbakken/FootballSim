package footballsim.layers;

public class LayerStack {
  private Layer[] m_Layers;
  private int m_Size;
  private int m_Top, m_Bot;

  public LayerStack() {
    m_Size = 4;
    m_Top = 1;
    m_Bot = 2;
    m_Layers = new Layer[m_Size];
  }

  public void pushLayer(Layer layer) {
    pushTop(layer);
    layer.onAttach();
  }

  public Layer popLayer() {
    Layer layer = popTop();
    layer.onDetach();
    return layer;
  }

  public void pushOverlay(Layer overlay) {
    pushBot(overlay);
    overlay.onAttach();
  }

  public Layer PopOverlay() {
    Layer overlay = popBot();
    overlay.onDetach();
    return overlay;
  }

  public boolean isEmpty() {
    return m_Bot > m_Top;
  }

  public int getCount() {
    return m_Top - m_Bot;
  }

  public int getSize() {
    return m_Size;
  }

  public int getFirst() { return m_Bot; }
  public int getLast() { return getCount(); }

  private void expand() {
    m_Size *= 2;
    Layer[] layers = new Layer[m_Size];
    if (m_Top + 1 - m_Bot >= 0)
      System.arraycopy(m_Layers, m_Bot, layers, m_Bot, m_Top + 1 - m_Bot);
    m_Layers = layers;
  }

  private void pushTop(Layer layer) {
    if (m_Top + 1 >= m_Size) {
      expand();
    }
    m_Top++;
    m_Layers[m_Top] = layer;
  }

  private Layer popTop() {
    Layer layer = m_Layers[m_Top];
    m_Top--;
    return layer;
  }

  private void pushBot(Layer layer) {
    if (m_Bot == 0) {
      if (m_Top + 1 >= m_Size) {
        expand();
      }
      if (m_Top + 1 >= 0)
        System.arraycopy(m_Layers, 0, m_Layers, 1, m_Top + 1);
      m_Layers[0] = layer;
    } else {
      m_Bot--;
      m_Layers[m_Bot] = layer;
    }
  }

  private Layer popBot() {
    Layer layer = m_Layers[m_Bot];
    m_Bot++;
    return layer;
  }

  public Layer get(int i) {
    return m_Layers[i];
  }
}

