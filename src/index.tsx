import { NativeModules, NativeEventEmitter } from 'react-native';

type LiphyType = {
  startTracking(): void;
  stopTracking(): void;
  setIsFront(isFront: boolean): void;
  addEventListener: (cb: (data: { lightId: string }) => void) => () => void;
  removeEventListener: (cb: (data: { lightId: string }) => void) => void;
};

const { Liphy } = NativeModules;

const LiphyEventEmitter = new NativeEventEmitter(Liphy);

Liphy.addEventListener = (cb: (data: { lightId: string }) => void) => {
  LiphyEventEmitter.addListener('LightDetected', cb);
  return () => {
    LiphyEventEmitter.removeListener('LightDetected', cb);
  };
};

Liphy.removeEventListener = (cb: (data: { lightId: string }) => void) => {
  LiphyEventEmitter.removeListener('LightDetected', cb);
};

export default Liphy as LiphyType;
