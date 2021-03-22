#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>
#import <LightFlySDK/LFLightManager.h>

@interface Liphy : RCTEventEmitter <RCTBridgeModule, LFLightManagerDelegate>

@property (nonatomic, strong) LFLightManager *lightManager;

@end
