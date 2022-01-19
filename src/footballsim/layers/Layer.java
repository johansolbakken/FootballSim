package footballsim.layers;

import footballsim.events.Event;

public class Layer {
  private String m_DebugName;

  public Layer(String name) { m_DebugName = name; }
  public void onAttach() {}
  public void onDetach() {}
  public void onUpdate() {}
  public void onEvent(Event event) {}

  @Override
  public String toString() {
    return m_DebugName;
  }
}
