#import "Liphy.h"
#import <LightFlySDK/LFLight.h>

@implementation Liphy {
  bool hasListeners;
}

RCT_EXPORT_MODULE()

- (void)initializeLightManager {
  if (self.lightManager == nil) {
    self.lightManager = [[LFLightManager alloc] init];
    self.lightManager.delegate = self;
    self.lightManager.activationKey = @"axscbhawe873d0asc70382";
  }
}

RCT_EXPORT_METHOD(startTracking)
{
  [self initializeLightManager];
  [self.lightManager startTracking];
}

RCT_EXPORT_METHOD(setIsFront:(BOOL)isFront)
{
  [self initializeLightManager];
  [self.lightManager setIsFront:isFront];
}

RCT_EXPORT_METHOD(stopTracking)
{
  [self initializeLightManager];
  [self.lightManager stopTracking];
}

- (void)startObserving {
    hasListeners = YES;
}

- (void)stopObserving {
    hasListeners = NO;
}

- (void)lightManager:(LFLightManager *)manager didTrackLight:(LFLight *)light {
  if (hasListeners) {
    [self sendEventWithName:@"LightDetected" body:@{@"lightId": light.identifier}];
  }
}

- (void)lightManager:(LFLightManager *)manager didUpdateProgress:(float)progress {

}

- (NSArray<NSString *> *)supportedEvents {
  return @[@"LightDetected"];
}

@end
